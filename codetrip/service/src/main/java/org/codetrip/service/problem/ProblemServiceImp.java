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
                }
                problemVOs.add(vo);
            }
        }
        return problemVOs;
    }
}
