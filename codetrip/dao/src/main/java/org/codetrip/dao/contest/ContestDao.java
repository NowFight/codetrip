package org.codetrip.dao.contest;

import org.codetrip.model.contest.ContestModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
public interface ContestDao {
    /**
     * 添加比赛
     *
     * @param contest
     * @return boolean
     * */
    boolean insertContest(ContestModel contest);

    /**
     * 通过比赛ID查询比赛
     *
     * @param contestId
     * @return ContestModel
     * */
    ContestModel queryContestByContestId(Integer contestId);

    /**
     * 列出所有比赛
     *
     * @return List
     * */
    List<ContestModel> queryAllContests();

    /**
     * 通过比赛ID更新比赛
     *
     * @param contestId
     * @param contest
     * @return boolean
     * */
    boolean updateContestByContestId(Integer contestId, ContestModel contest);
}
