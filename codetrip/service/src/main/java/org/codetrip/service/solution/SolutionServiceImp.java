package org.codetrip.service.solution;

import org.codetrip.dao.solution.SolutionDao;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/21.
 */
@Service("SolutionService")
public class SolutionServiceImp extends BaseService implements SolutionService {
    @Autowired
    private SolutionDao solutionDao;

    /**
     * 添加solution
     *
     * @param solution
     * @return boolean
     */
    @Override
    public boolean insertSolution(SolutionModel solution) {
        return solutionDao.insertSolution(solution);
    }

    /**
     * 通过solutionId查找solution记录
     *
     * @param solutionId
     * @return SolutionModel
     */
    @Override
    public SolutionModel querySolutionBySolutionId(int solutionId) {
        return solutionDao.querySolutionBySolutionId(solutionId);
    }

    /**
     * 通过用户ID查询solution记录
     *
     * @param userId
     * @return List
     */
    @Override
    public List<SolutionModel> querySolutionByUserId(int userId) {
        return solutionDao.querySolutionByUserId(userId);
    }

    /**
     * 通过problemId查询solution记录
     *
     * @param problemId
     * @return List
     */
    @Override
    public List<SolutionModel> querySolutionByProblemId(int problemId) {
        return solutionDao.querySolutionByProblemId(problemId);
    }

    /**
     * 通过teamId查询solution记录
     *
     * @param teamId
     * @return List
     */
    @Override
    public List<SolutionModel> querySolutionByTeamId(int teamId) {
        return solutionDao.querySolutionByTeamId(teamId);
    }

    /**
     * 列出所有的solution记录
     *
     * @return List
     */
    @Override
    public List<SolutionModel> queryAllSolutions() {
        return solutionDao.queryAllSolutions();
    }

    /**
     * 通过solutionId更新solution
     *
     * @param solutionId
     * @param solution
     * @return boolean
     */
    @Override
    public boolean updateSolutionBySolutionId(int solutionId, SolutionModel solution) {
        return solutionDao.updateSolutionBySolutionId(solutionId, solution);
    }
}
