package org.codetrip.service.participator;

import org.codetrip.common.vo.ParticipantVO;
import org.codetrip.model.participant.ParticipantModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/4/27.
 */
public interface ParticipatorService {
    /**
     * 注册比赛
     *
     * @param contestId
     * @param userId
     * @param teamName
     * */
    public void registerContest(Long contestId, Long userId, String teamName);

    /**
     * 列出比赛的所有参加者
     *
     * @return List
     * */
    public List<ParticipantVO> listParticipators(Long contestId);

    /**
     * 对team添加成员
     *
     * @param userId
     * @param teamId
     * */
    public void addTeamMember(Long userId, Long teamId);

    /**
     * 检查当前用户是否已经参加了这场比赛
     *
     * @param contestId
     * @param userId
     * @return boolean
     * */
    public boolean checkParticipator(Long userId, Long contestId);

    /**
     * 获得用户所在的队伍
     *
     * @param contestId
     * @param userId
     * @return ParticipantModel
     * */
    public ParticipantVO getParticipator(Long userId, Long contestId);

    /**
     * 获得队伍信息
     *
     * @param teamId
     * @return ParticipantVO
     * */
    public ParticipantVO getparticipator(Long teamId);
}
