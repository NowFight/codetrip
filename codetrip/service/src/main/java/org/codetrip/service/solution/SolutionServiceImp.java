package org.codetrip.service.solution;

import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.common.so.SolutionSO;
import org.codetrip.common.vo.ParticipantVO;
import org.codetrip.common.vo.SolutionVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.dao.solution.SolutionDao;
import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.dao.user.UserDao;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.BaseService;
import org.codetrip.service.participator.ParticipatorService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/2/21.
 */
@Service("SolutionService")
public class SolutionServiceImp extends BaseService implements SolutionService {
    @Autowired
    private SolutionDao solutionDao;

    @Autowired
    private ProblemStatisticDao statisticDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private ParticipatorService participatorService;

    @Autowired
    private Mapper dozerMapper;

    private final static Logger LOG = Logger.getLogger(SolutionService.class.getName());

    /**
     * 提交代码, 并更新题目的提交次数
     *
     * @param solution
     */
    @Override
    @Transactional
    public void commit(SolutionModel solution) {
        if (solution == null) {
            LOG.warning("solution is null when commit");
            return;
        }

        solutionDao.insert(solution);
        ProblemStatisticSO so = new ProblemStatisticSO();
        so.setProblemId(solution.getProblemId());

        //如果contestId不为null，则表示这是一次来自比赛的提交
        if (solution.getContestId() != null) {
            so.setContestId(solution.getContestId());
        }

        List<ProblemStatisticModel> statistics = statisticDao.findBySO(so);
        if (statistics != null) {
            ProblemStatisticModel statistic = new ProblemStatisticModel();
            statistic.setId(statistics.get(0).getId());
            statistic.setSubmissions(statistics.get(0).getSubmissions() + 1);
            statisticDao.update(statistic);
        } else {
            LOG.warning(String.format("problem ID = %d not have statistic record", solution.getProblemId()));
        }
    }

    /**
     * 列出所有的solution记录
     *
     * @return List
     */
    @Override
    @Transactional
    public List<SolutionVO> listAllSolutions() {
        SolutionSO so = new SolutionSO();
        List<SolutionModel> solutions = solutionDao.findBySO(so);

        List<SolutionVO> solutionVOs = new ArrayList<SolutionVO>();
        if (!solutions.isEmpty()) {
            for (SolutionModel solution : solutions) {
                SolutionVO vo = dozerMapper.map(solution, SolutionVO.class);

                vo.setAccessable(Boolean.FALSE);

                ProblemModel problem = problemDao.find(solution.getProblemId());

                if (problem != null) {
                    vo.setTitle(problem.getTitle());
                } else {
                    vo.setTitle("UNKNOWN");
                    LOG.warning("can't find the problem with given solution");
                }

                if (solution.getUserId() != null) {
                    UserModel user = userDao.find(solution.getUserId());
                    vo.setNikeName(user.getNikeName());
                } else if (solution.getTeamId() != null) {
                    ParticipantVO pvo = participatorService.getparticipator(solution.getTeamId());
                    vo.setNikeName(pvo.getTeamName());
                }
                solutionVOs.add(vo);
            }
        }

        //依据ID从大到小排序
        Collections.sort(solutionVOs, new Comparator<SolutionVO>() {
            @Override
            public int compare(SolutionVO o1, SolutionVO o2) {
                return o1.getId() < o2.getId() ? 1 : (o1.getId() == o2.getId() ? 0 : -1);
            }
        });

        return solutionVOs;
    }

    /**
     * 获取solution记录中的代码
     *
     * @param id
     * @return SolutionVO
     */
    @Override
    public SolutionVO getCodeContent(Long id) {
        SolutionModel solution = solutionDao.find(id);

        if (solution != null) {
            SolutionVO vo = dozerMapper.map(solution, SolutionVO.class);
            return vo;
        } else {
            LOG.warning("can't find solution with solution id = " + id);
            return null;
        }
    }
}
