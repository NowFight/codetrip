package org.codetrip.dao.solution;

import org.codetrip.model.solution.SolutionModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/20.
 */
public interface SolutionDao {

    /**
     * 添加solution
     * @param solution
     * @return boolean
     * */
    public boolean insertSolution(SolutionModel solution);

    /**
     * 通过solutionId查找solution记录
     *
     * @param solutionId
     * @return SolutionModel
     * */
    public SolutionModel querySolutionBySolutionId(int solutionId);

    /**
     * 通过用户ID查询solution记录
     *
     * @param userId
     * @return List
     * */
    public List<SolutionModel> querySolutionByUserId(int userId);

    /**
     * 通过problemId查询solution记录
     *
     * @param problemId
     * @return List
     * */
    public List<SolutionModel> querySolutionByProblemId(int problemId);

    /**
     * 通过teamId查询solution记录
     *
     * @param teamId
     * @return List
     * */
    public List<SolutionModel> querySolutionByTeamId(int teamId);

    /**
     * 列出所有的solution记录
     *
     * @return List
     * */
    public List<SolutionModel> queryAllSolutions();

    /**
     * 通过solutionId更新solution
     *
     * @param solutionId
     * @param solution
     * @return boolean
     * */
    public boolean updateSolutionBySolutionId(int solutionId, SolutionModel solution);
}
