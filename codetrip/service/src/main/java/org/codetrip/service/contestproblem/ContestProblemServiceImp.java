package org.codetrip.service.contestproblem;

import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.dao.contestproblem.ContestProblemDao;
import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/22.
 */
@Service
public class ContestProblemServiceImp implements ContestProblemService {

    private final static Logger LOG = Logger.getLogger(ContestProblemService.class.getName());

    @Autowired
    private ContestProblemDao contestProblemDao;

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private ProblemStatisticDao statisticDao;

    @Autowired
    private Mapper dozerMapper;

    /**
     * 批量添加比赛题目
     *
     * @param contestId
     * @param problemIds
     */
    @Override
    public void batchAddProblem(Long contestId, List<Long> problemIds) {
        if (problemIds != null) {
            if (contestId != null) {
                for (Long problemId : problemIds) {
                    ContestProblemModel contestProblem = new ContestProblemModel();
                    contestProblem.setContestId(contestId);
                    contestProblem.setProblemId(problemId);
                    contestProblemDao.insert(contestProblem);
                }
            } else {
                LOG.warning("contest is null when add problems to contest");
            }
        } else {
            LOG.warning("problemIds is null when add problems to contest");
        }
    }

    /**
     * 列出比赛中包含的题目
     *
     * @param contestId
     * @return List
     */
    @Override
    public List<ProblemVO> listContestProblems(Long contestId) {
        ContestProblemSO so = new ContestProblemSO();
        so.setContestId(contestId);
        List<ContestProblemModel> contestProblems = contestProblemDao.findBySO(so);

        if (!contestProblems.isEmpty()) {
            List<ProblemVO> problemVOs = new ArrayList<ProblemVO>();
            for (ContestProblemModel contestProblem : contestProblems) {
                ProblemModel problem = problemDao.find(contestProblem.getProblemId());
                if (problem != null) {
                    ProblemVO vo = dozerMapper.map(problem, ProblemVO.class);
                    ProblemStatisticSO statisticSO = new ProblemStatisticSO();
                    statisticSO.setProblemId(problem.getId());
                    List<ProblemStatisticModel> statistics = statisticDao.findBySO(statisticSO);
                    if (!statistics.isEmpty()) {
                        vo.setAccept(statistics.get(0).getAccept());
                        vo.setSubmissions(statistics.get(0).getSubmissions());
                    } else {
                        LOG.warning(String.format("problem ID = %d has no statistic", problem.getId()));
                    }
                    problemVOs.add(vo);
                } else {
                    LOG.warning("problem ID : " + contestProblem.getProblemId() + " is not in problem set");
                }
            }
            return problemVOs;
        } else {
            return null;
        }
    }
}
