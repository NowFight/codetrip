package org.codetrip.dao.problem;

import org.codetrip.model.problem.ProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/12.
 */
public interface ProblemDao {

    /**
     * 添加题目
     * @param problem
     * @return boolean
     * */
    public boolean insertProblem(ProblemModel problem);

    /**
     * 通过用户ID查询题目
     * @param userId
     * @return List
     * */
    public List<ProblemModel> queryProblemsByUserId(int userId);

    /**
     * 通过题目ID查询题目
     * @param problemId
     * @return ProblemModel
     * */
    public ProblemModel queryProblemByProblemId(int problemId);

    /**
     * 通过比赛ID查询题目
     * @param contestId
     * @return List
     * */
    public List<ProblemModel> queryProblemsByContestId(int contestId);

    /**
     * 通过题目ID更新题目信息
     * @param problemId
     * @param problem
     * @return boolean
     * */
    public boolean updateProblemByProblemId(int problemId, ProblemModel problem);

    /**
     * 列出所有公开的题目
     *
     * @return List
     * */
    public List<ProblemModel> listAllPublicProblem();
}
