package org.codetrip.service.problem;

import org.codetrip.common.so.ProblemSO;
import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.common.so.TestCaseSO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.dao.testcase.TestCaseDao;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.service.BaseService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/2/13.
 */
@Service("ProblemService")
public class ProblemServiceImp extends BaseService implements ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private ProblemStatisticDao statisticDao;

    @Autowired
    private TestCaseDao testCaseDao;

    @Autowired
    private Mapper dozerMapper;

    private final static Logger LOG = Logger.getLogger(ProblemService.class.getName());

    /**
     * 添加题目
     *
     * @param problem
     */
    @Override
    @Transactional
    public void addProblem(ProblemModel problem) {
        if (problem == null) {
            LOG.warning("problem is null when add problem");
            return;
        }

        problemDao.insert(problem);

        //init the statistic
        ProblemStatisticModel statistic = new ProblemStatisticModel();
        statistic.setProblemId(problem.getId());
        statistic.init();
        statistic.setContestId(0L);
        statisticDao.insert(statistic);
    }

    /**
     * 获得用户拥有的所有题目
     *
     * @param userId
     * @return List
     */
    @Override
    @Transactional
    public List<ProblemVO> getCurrentUsersAllProblems(Long userId) {
        List<ProblemVO> problemVOs = new ArrayList<ProblemVO>();
        ProblemSO so = new ProblemSO();
        so.setUserId(userId);
        List<ProblemModel> problems = problemDao.findBySO(so);

        if (!problems.isEmpty()) {
            for (ProblemModel problem : problems) {
                ProblemVO vo = dozerMapper.map(problem, ProblemVO.class);
                TestCaseSO testCaseSO = new TestCaseSO();
                testCaseSO.setProblemId(problem.getId());
                vo.setCaseNumber(testCaseDao.findBySO(testCaseSO).size());
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
            }
        }
        return problemVOs;
    }

    /**
     * 列出所有的题目
     *
     * @param id
     * @return ProblemVO
     */
    @Override
    @Transactional
    public ProblemVO viewProblem(Long id) {
        ProblemModel problem = problemDao.find(id);
        if (problem != null) {
            ProblemVO vo = dozerMapper.map(problem, ProblemVO.class);

            ProblemStatisticSO sso = new ProblemStatisticSO();
            sso.setProblemId(id);
            List<ProblemStatisticModel> statistics = statisticDao.findBySO(sso);
            if (!statistics.isEmpty()) {
                vo.setAccept(statistics.get(0).getAccept());
                vo.setSubmissions(statistics.get(0).getSubmissions());
            } else {
                LOG.warning(String.format("problem ID = %d has no statistic", problem.getId()));
            }

            return vo;
        }
        return null;
    }

    /**
     * 列出所有的题目
     *
     * @return List
     */
    @Override
    @Transactional
    public List<ProblemVO> listAllProblems() {
        ProblemSO so = new ProblemSO();
        so.setVisible(Boolean.TRUE);
        List<ProblemModel> problems = problemDao.findBySO(so);
        List<ProblemVO> problemVOs = new ArrayList<ProblemVO>();

        if (!problems.isEmpty()) {
            for (ProblemModel problem : problems) {
                ProblemVO vo = dozerMapper.map(problem, ProblemVO.class);
                ProblemStatisticSO sso = new ProblemStatisticSO();
                sso.setProblemId(problem.getId());
                List<ProblemStatisticModel> statistics = statisticDao.findBySO(sso);
                if (!statistics.isEmpty()) {
                    vo.setAccept(statistics.get(0).getAccept());
                    vo.setSubmissions(statistics.get(0).getSubmissions());
                } else {
                    LOG.warning(String.format("problem ID = %d has no statistic", problem.getId()));
                }
                problemVOs.add(vo);
            }
            // sort by id
            Collections.sort(problemVOs, new Comparator<ProblemVO>() {
                @Override
                public int compare(ProblemVO o1, ProblemVO o2) {
                    return o1.getId() > o2.getId() ? 1 : (o1.getId() == o2.getId() ? 0 : -1);
                }
            });
        }
        return problemVOs;
    }
}
