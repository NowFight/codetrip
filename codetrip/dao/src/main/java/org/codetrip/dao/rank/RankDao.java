package org.codetrip.dao.rank;

import org.codetrip.model.rank.RankModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface RankDao {
    /**
     * 插入rank信息
     * @param rank
     * @return boolean
     * */
    public boolean insertNew(RankModel rank);

    /**
     * 通过team ID和比赛ID查询rank信息
     * @param teamId
     * @param contestId
     * @return RankModel
     * */
    public RankModel queryByTeamIdAndContestId(int teamId, int contestId);

    /**
     * 通过contest ID来查询rank信息
     * @param contestId
     * @return List
     * */
    public List<RankModel> queryByContestId(int contestId);

    /**
     * 通过team ID和比赛ID更新rank信息
     * @param teamId
     * @param contestId
     * @param rank
     * @return boolean
     * */
    public boolean updateByTeamIdAndContestId(int teamId, int contestId, RankModel rank);
}
