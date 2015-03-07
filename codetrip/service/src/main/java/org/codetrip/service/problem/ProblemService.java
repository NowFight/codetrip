package org.codetrip.service.problem;

import org.codetrip.model.problem.ProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/13.
 */
public interface ProblemService {

    /**
     * 添加题目
     * @param problem
     * @return boolean
     * */
    public boolean insertProblem(ProblemModel problem);

    /**
     * 根据题目ID查询题目
     * @param problemId
     * @return List
     * */
    public ProblemModel queryProblemByProblemId(int problemId);

    /**
     * 根据用户ID查询题目
     * @param userId
     * @return List
     * */
    public List<ProblemModel> queryProblemsByUserId(int userId);

    /**
     * 根据题目ID更新题目
     * @param problem
     * @param problemId
     * */
    public boolean updateProblemByProblemId(int problemId, ProblemModel problem);

    /**
     * 列出所有公开的题目
     *
     * @return List
     * */
    public List<ProblemModel> listAllPublicProblem();

    /**
     * 查找属于当前用户的最新的题目ID
     * @param userId
     * @return int
     * */
    public int queryLatestProblemIdByUserId(int userId);
}
