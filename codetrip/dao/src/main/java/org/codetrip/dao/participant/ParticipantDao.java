package org.codetrip.dao.participant;

import org.codetrip.model.participant.ParticipantModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface ParticipantDao {
    /**
     * 创建参赛队伍
     *
     * @param participant
     * @return boolean
     * */
    public boolean insertNew(ParticipantModel participant);

    /**
     * 通过team ID查询参赛队伍
     *
     * @param teamId
     * @return participant
     * */
    public ParticipantModel queryByTeamId(int teamId);

    /**
     * 通过比赛ID查询参赛队伍
     *
     * @param contestId
     * @return List
     * */
    public List<ParticipantModel> queryByContestId(int contestId);

    /**
     * 通过team ID更新参赛队伍信息
     *
     * @param teamId
     * @param participant
     * @return boolean
     * */
    public boolean updateByTeamId(int teamId, ParticipantModel participant);
}
