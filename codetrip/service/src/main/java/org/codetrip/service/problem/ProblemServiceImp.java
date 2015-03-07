package org.codetrip.service.problem;

import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RuFeng on 2015/2/13.
 */
@Service("ProblemService")
public class ProblemServiceImp extends BaseService implements ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private ProblemStatisticDao statisticDao;

    /**
     * 添加题目
     * @param problem
     * @return boolean
     * */
    @Override
    public boolean insertProblem(ProblemModel problem) {
        if (problemDao.insertProblem(problem)) {
            ProblemStatisticModel statisticModel = new ProblemStatisticModel();
            statisticModel.setProblemId(problem.getProblemId());
            if (statisticDao.insertStatistic(statisticModel)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据题目ID查询题目
     * @param problemId
     * @return List
     * */
    @Override
    public ProblemModel queryProblemByProblemId(int problemId) {
        ProblemModel problem = problemDao.queryProblemByProblemId(problemId);
        return problem;
    }

    /**
     * 根据用户ID查询题目
     * @param userId
     * @return List
     * */
    @Override
    public List<ProblemModel> queryProblemsByUserId(int userId) {
        List<ProblemModel> problems = problemDao.queryProblemsByUserId(userId);
        return problems;
    }

    /**
     * 根据题目ID更新题目
     *
     * @param problemId
     * @param problem
     */
    @Override
    public boolean updateProblemByProblemId(int problemId, ProblemModel problem) {
        return problemDao.updateProblemByProblemId(problemId, problem);
    }

    /**
     * 列出所有公开的题目
     *
     * @return List
     */
    @Override
    public List<ProblemModel> listAllPublicProblem() {
        return problemDao.listAllPublicProblem();
    }

    /**
     * 查找属于当前用户的最新的题目ID
     *
     * @param userId
     * @return int
     */
    @Override
    public int queryLatestProblemIdByUserId(int userId) {
        List<ProblemModel> problems = problemDao.queryProblemsByUserId(userId);
        if (problems != null) {
            Collections.sort(problems, new Comparator<ProblemModel>() {
                @Override
                public int compare(ProblemModel o1, ProblemModel o2) {
                    return o1.getProblemId() > o2.getProblemId() ? -1 :
                            (o1.getProblemId() < o2.getProblemId() ? 1 : 0);
                }
            });
            return problems.get(0).getProblemId();
        } else {
            return -1;  //代表没有题目
        }
    }
}
