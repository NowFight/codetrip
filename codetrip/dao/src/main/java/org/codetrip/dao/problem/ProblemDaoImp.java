package org.codetrip.dao.problem;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.problem.ProblemModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/12.
 */
@Repository("ProblemDao")
public class ProblemDaoImp extends BaseDao implements ProblemDao {
    /**
     * 添加题目
     * @param problem
     * @return boolean
     * */
    @Override
    public boolean insertProblem(ProblemModel problem) {
        if (getSession().insert(getNamespace() + ".insertProblem", problem) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过用户ID查询题目
     * @param userId
     * @return List
     * */
    @Override
    public List<ProblemModel> queryProblemsByUserId(int userId) {
        List<ProblemModel> problems = getSession()
                .selectList(getNamespace() + ".queryProblemsByUserId", userId);
        if (problems.size() == 0) {
            return null;
        } else {
            return problems;
        }
    }

    /**
     * 通过题目ID查询题目
     * @param problemId
     * @return Problem
     * */
    @Override
    public ProblemModel queryProblemByProblemId(int problemId) {
        return getSession().selectOne(getNamespace() + ".queryProblemsByProblemId", problemId);
    }

    /**
     * 通过比赛ID查询题目
     * @param contestId
     * @return List
     * */
    @Override
    public List<ProblemModel> queryProblemsByContestId(int contestId) {
        List<ProblemModel> problems = getSession()
                .selectList(getNamespace() + ".queryProblemsByContestId", contestId);
        if (problems.size() == 0) {
            return null;
        } else {
            return problems;
        }
    }

    /**
     * 通过题目ID更新题目信息
     * @param problemId
     * @param problem
     * @return boolean
     * */
    @Override
    public boolean updateProblemByProblemId(int problemId, ProblemModel problem) {
        problem.setProblemId(problemId);
        if (getSession().update(getNamespace() + ".updateProblemByProblemId", problem) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 列出所有公开的题目
     *
     * @return List
     * */
    public List<ProblemModel> listAllPublicProblem() {
        List<ProblemModel> problems = getSession().selectList(getNamespace() + ".listAllPublicProblem");
        if (problems.size() == 0) {
            return null;
        } else {
            return problems;
        }
    }
}
