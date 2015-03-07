package org.codetrip.dao.solution;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.solution.SolutionModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/21.
 */
@Repository("SolutionDao")
public class SolutionDaoImp extends BaseDao implements SolutionDao {

    /**
     * 添加solution
     *
     * @param solution
     * @return boolean
     */
    @Override
    public boolean insertSolution(SolutionModel solution) {
        if (getSession().insert(getMapperPrefix() + ".insertSolution", solution) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过solutionId查找solution记录
     *
     * @param solutionId
     * @return SolutionModel
     */
    @Override
    public SolutionModel querySolutionBySolutionId(int solutionId) {
        return getSession().selectOne(getMapperPrefix() + ".querySolutionBySolutionId", solutionId);
    }

    /**
     * 通过用户ID查询solution记录
     *
     * @param userId
     * @return List
     */
    @Override
    public List<SolutionModel> querySolutionByUserId(int userId) {
        List<SolutionModel> solutions = getSession().selectList(getMapperPrefix() + ".querySolutionByUserId", userId);
        if (solutions.size() == 0) {
            return null;
        } else {
            return solutions;
        }
    }

    /**
     * 通过problemId查询solution记录
     *
     * @param problemId
     * @return List
     */
    @Override
    public List<SolutionModel> querySolutionByProblemId(int problemId) {
        List<SolutionModel> solutions = getSession().selectOne(getMapperPrefix() + ".querySolutionByProblemId", problemId);
        if (solutions.size() == 0) {
            return null;
        } else {
            return solutions;
        }
    }

    /**
     * 通过teamId查询solution记录
     *
     * @param teamId
     * @return SolutionModel
     */
    @Override
    public List<SolutionModel> querySolutionByTeamId(int teamId) {
        List<SolutionModel> solutions = getSession().selectOne(getMapperPrefix() + ".querySolutionByTeamId", teamId);
        if (solutions.size() == 0) {
            return null;
        } else {
            return solutions;
        }
    }

    /**
     * 列出所有的solution记录
     *
     * @return List
     */
    @Override
    public List<SolutionModel> queryAllSolutions() {
        List<SolutionModel> solutions = getSession().selectList(getMapperPrefix() + ".queryAllSolutions");
        if (solutions.size() == 0) {
            return null;
        } else {
            return solutions;
        }
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
        solution.setSolutionId(solutionId);
        if (getSession().update(getMapperPrefix() + ".updateSolutionBySolutionId", solution) == 1) {
            return true;
        }
        return false;
    }
}
