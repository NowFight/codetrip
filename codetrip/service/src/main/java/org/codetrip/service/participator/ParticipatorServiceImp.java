package org.codetrip.service.participator;

import org.codetrip.common.so.MemberShipSO;
import org.codetrip.common.so.ParticipantSO;
import org.codetrip.common.vo.ParticipantVO;
import org.codetrip.dao.membership.MemberShipDao;
import org.codetrip.dao.participant.ParticipantDao;
import org.codetrip.dao.user.UserDao;
import org.codetrip.model.membership.MembershipModel;
import org.codetrip.model.participant.ParticipantModel;
import org.codetrip.model.user.UserModel;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/27.
 */
@Service
public class ParticipatorServiceImp implements ParticipatorService {
    private static final Logger LOG = Logger.getLogger(ParticipatorService.class.getName());

    @Autowired
    private MemberShipDao memberShipDao;

    @Autowired
    private ParticipantDao participantDao;

    @Autowired
    private Mapper dozerMapper;

    @Autowired
    private UserDao userDao;

    /**
     * 注册比赛
     *
     * @param contestId
     * @param userId
     * @param teamName
     */
    @Override
    @Transactional
    public void registerContest(Long contestId, Long userId, String teamName) {
        if (contestId == null) {
            LOG.warning("contest Id is null when register contest");
            return;
        }

        if (userId == null) {
            LOG.warning("userId is null when register contest");
            return;
        }

        if (teamName == null) {
            LOG.warning("teamName is null when register contest");
            return;
        }
        ParticipantModel participant = new ParticipantModel();
        participant.setTeamName(teamName);
        participant.setContestId(contestId);
        participant.setRegisteDate(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(System.currentTimeMillis()));
        participantDao.insert(participant);
        MembershipModel membership = new MembershipModel();
        membership.setUserId(userId);membership.setTeamId(participant.getId());
        memberShipDao.insert(membership);
    }

    /**
     * 列出比赛的所有参加者
     *
     * @param contestId
     * @return List
     */
    @Override
    @Transactional
    public List<ParticipantVO> listParticipators(Long contestId) {
        List<ParticipantVO> participantVOs = new ArrayList<ParticipantVO>();

        if (contestId == null) {
            LOG.warning("contest id is null when list participators");
            return participantVOs;
        }
        ParticipantSO so = new ParticipantSO();
        so.setContestId(contestId);
        List<ParticipantModel> participants = participantDao.findBySO(so);
        if (!participants.isEmpty()) {
            for (ParticipantModel participant : participants) {
                ParticipantVO vo = dozerMapper.map(participant, ParticipantVO.class);
                MemberShipSO memSO = new MemberShipSO();
                memSO.setTeamId(participant.getId());
                List<MembershipModel> members = memberShipDao.findBySO(memSO);
                if (!members.isEmpty()) {
                    List<String> users = new ArrayList<String>();
                    for (MembershipModel member : members) {
                        UserModel user = userDao.find(member.getUserId());
                        users.add(user.getNikeName());
                    }
                    vo.setMembers(users);
                } else {
                    LOG.warning("participator ID = " + participant.getId() + " has no members");
                }
                participantVOs.add(vo);
            }
        }
        return participantVOs;
    }

    /**
     * 对team添加成员
     *
     * @param userId
     * @param teamId
     */
    @Override
    public void addTeamMember(Long userId, Long teamId) {
        if (userId == null) {
            LOG.warning("user id is null when add team member");
            return;
        }

        if (teamId == null) {
            LOG.warning("team id is null when add team member");
            return;
        }

        MemberShipSO so = new MemberShipSO();
        so.setTeamId(teamId);
        so.setUserId(userId);
        List <MembershipModel> members = memberShipDao.findBySO(so);
        if (members.isEmpty()) {
            MembershipModel member = new MembershipModel();
            member.setTeamId(teamId);
            member.setUserId(userId);
            memberShipDao.insert(member);
        } else {
            LOG.warning("user id = " + userId + " is already in this team Id = " + teamId);
        }
    }

    /**
     * 检查当前用户是否已经参加了这场比赛
     *
     * @param userId
     * @param contestId
     * @return boolean
     */
    @Override
    public boolean checkParticipator(Long userId, Long contestId) {
        ParticipantSO so = new ParticipantSO();
        so.setContestId(contestId);
        List<ParticipantModel> participants = participantDao.findBySO(so);
        for (ParticipantModel participant : participants) {
            MemberShipSO mso = new MemberShipSO();
            mso.setTeamId(participant.getId());
            List<MembershipModel> memberships = memberShipDao.findBySO(mso);
            for (MembershipModel membership : memberships) {
                if (membership.getUserId() == userId) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获得用户所在的队伍
     *
     * @param userId
     * @param contestId
     * @return ParticipantModel
     */
    @Override
    public ParticipantVO getParticipator(Long userId, Long contestId) {
        ParticipantSO so = new ParticipantSO();
        so.setContestId(contestId);
        List<ParticipantModel> participants = participantDao.findBySO(so);
        for (ParticipantModel participant : participants) {
            MemberShipSO mso = new MemberShipSO();
            mso.setTeamId(participant.getId());
            List<MembershipModel> memberships = memberShipDao.findBySO(mso);
            for (MembershipModel membership : memberships) {
                if (membership.getUserId() == userId) {
                    return dozerMapper.map(participant, ParticipantVO.class);
                }
            }
        }
        return null;
    }

    /**
     * 获得队伍信息
     *
     * @param teamId
     * @return ParticipantVO
     */
    @Override
    public ParticipantVO getparticipator(Long teamId) {
        ParticipantModel participant = participantDao.find(teamId);
        if (participant != null) {
            return dozerMapper.map(participant, ParticipantVO.class);
        }
        return null;
    }
}
