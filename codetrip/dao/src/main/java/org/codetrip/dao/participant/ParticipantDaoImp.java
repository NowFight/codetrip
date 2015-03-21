package org.codetrip.dao.participant;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.participant.ParticipantModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository("ParticipantDao")
public class ParticipantDaoImp extends BaseDao implements ParticipantDao {
    /**
     * 创建参赛队伍
     *
     * @param participant
     * @return boolean
     */
    @Override
    public boolean insertNew(ParticipantModel participant) {
        if (getSession().insert(getMapperPrefix() + ".insertNew", participant) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过team ID查询参赛队伍
     *
     * @param teamId
     * @return participant
     */
    @Override
    public ParticipantModel queryByTeamId(int teamId) {
        return getSession().selectOne(getMapperPrefix() + ".queryByTeamId", teamId);
    }

    /**
     * 通过比赛ID查询参赛队伍
     *
     * @param contestId
     * @return List
     */
    @Override
    public List<ParticipantModel> queryByContestId(int contestId) {
        List<ParticipantModel> participants =
                getSession().selectList(getMapperPrefix() + ".queryByContestId", contestId);
        if (participants.isEmpty()) {
            return null;
        } else {
            return participants;
        }
    }

    /**
     * 通过team ID更新参赛队伍信息
     *
     * @param teamId
     * @param participant
     * @return boolean
     */
    @Override
    public boolean updateByTeamId(int teamId, ParticipantModel participant) {
        participant.setTeamId(teamId);
        if (getSession().update(getMapperPrefix() + ".updateByTeamId", participant) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
