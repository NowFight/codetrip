package org.codetrip.dao.contestproblem;

import org.codetrip.model.contestproblem.ContestProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface ContestProblemDao {
    /**
     * 添加比赛题目
     *
     * @param problems
     * @return boolean
     * */
    public boolean insertNew(ContestProblemModel problems);

    /**
     * 通过题目ID和比赛ID删除比赛题目
     *
     * @param contestId
     * @param problemId
     * @return boolean
     * */
    public boolean deleteByContestIdAndProblemId(int contestId, int problemId);

    /**
     * 通过比赛ID查找题目
     *
     * @param contestId
     * @return List
     * */
    public List<ContestProblemModel> queryByContestId(int contestId);

    /**
     * 通过题目ID查找关联的比赛
     *
     * @param problemId
     * @return List
     * */
    public List<ContestProblemModel> queryByProblemId(int problemId);
}
