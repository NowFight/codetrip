package org.codetrip.dao.rank;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.rank.RankModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository("RankDao")
public class RankDaoImp extends BaseDao implements RankDao {
    /**
     * 插入rank信息
     *
     * @param rank
     * @return boolean
     */
    @Override
    public boolean insertNew(RankModel rank) {
        if (getSession().insert(getMapperPrefix() + ".insertNew", rank) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过team ID和比赛ID查询rank信息
     *
     * @param teamId
     * @param contestId
     * @return RankModel
     */
    @Override
    public RankModel queryByTeamIdAndContestId(int teamId, int contestId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("teamId", teamId);
        map.put("contestId", contestId);
        return getSession().selectOne(getMapperPrefix() + ".queryByTeamIdAndContestId", map);
    }

    /**
     * 通过contest ID来查询rank信息
     *
     * @param contestId
     * @return List
     */
    @Override
    public List<RankModel> queryByContestId(int contestId) {
        List<RankModel> ranks = getSession().selectList(getMapperPrefix() + ".queryByContestId", contestId);
        if (ranks.isEmpty()) {
            return null;
        } else {
            return ranks;
        }
    }

    /**
     * 通过team ID和比赛ID更新rank信息
     *
     * @param teamId
     * @param contestId
     * @param rank
     * @return boolean
     */
    @Override
    public boolean updateByTeamIdAndContestId(int teamId, int contestId, RankModel rank) {
        rank.setTeamId(teamId);
        rank.setContestId(contestId);
        if (getSession().update(getMapperPrefix() + ".updateByTeamIdAndContestId", rank) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
