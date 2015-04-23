package org.codetrip.service.contest;

import org.codetrip.common.enumerate.ContestStatus;
import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.common.so.ContestSO;
import org.codetrip.common.so.ParticipantSO;
import org.codetrip.common.util.DateUtil;
import org.codetrip.common.util.Time;
import org.codetrip.common.vo.ContestVO;
import org.codetrip.dao.contest.ContestDao;
import org.codetrip.dao.contestproblem.ContestProblemDao;
import org.codetrip.dao.participant.ParticipantDao;
import org.codetrip.model.contest.ContestModel;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.codetrip.model.participant.ParticipantModel;
import org.codetrip.service.BaseService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/3/14.
 */
@Service("ContestService")
public class ContestServiceImp extends BaseService implements ContestService {
    @Autowired
    private ContestDao contestDao;

    @Autowired
    private ContestProblemDao contestProblemDao;

    @Autowired
    private ParticipantDao participantDao;

    @Autowired
    private Mapper dozerMapper;

    private final static Logger LOG = Logger.getLogger(ContestService.class.getName());

    /**
     * 添加比赛
     *
     * @param contest
     */
    @Override
    public void addContest(ContestModel contest) {
        if (contest == null) {
            LOG.warning("contest is null when add contest");
            return;
        }
        contestDao.insert(contest);
    }

    /**
     * 列出用户的所有比赛
     *
     * @param userId
     * @return List
     */
    @Override
    @Transactional
    public List<ContestVO> listUsersContests(Long userId) {
        ContestSO so = new ContestSO();
        so.setUserId(userId);
        List<ContestModel> contests = contestDao.findBySO(so);

        return collectContestInfo(contests);
    }

    /**
     * 列出所有公共的比赛
     *
     * @return List
     */
    @Override
    public List<ContestVO> listAllPublicContests() {
        ContestSO so = new ContestSO();
        so.setPrivatable(Boolean.FALSE);
        List<ContestModel> contests = contestDao.findBySO(so);

        return collectContestInfo(contests);
    }

    /**
     * 收集比赛相关信息
     *
     * @param contests
     * @return List
     * */
    private List<ContestVO> collectContestInfo(List<ContestModel> contests) {
        List<ContestVO> contestVOs = null;
        if (!contests.isEmpty()) {
            contestVOs = new ArrayList<ContestVO>();
            for (ContestModel contest : contests) {
                ContestVO contestVO = dozerMapper.map(contest, ContestVO.class);
                ParticipantSO so1 = new ParticipantSO();
                so1.setContestId(contest.getId());
                List<ParticipantModel> participants = participantDao.findBySO(so1);
                contestVO.setParticipators(new Long(participants.size()));
                contestVO.setProblems(contestProblemDao.count(contest.getId()));
                try {
                    Time startTime = new Time(DateUtil.DateParser(contest.getStartTime(), "yyyy/MM/dd HH:mm"));
                    Time endTime = new Time(DateUtil.DateParser(contest.getEndTime(), "yyyy/MM/dd HH:mm"));
                    Time currentTime = new Time(DateUtil.DateParser(
                            new SimpleDateFormat("yyyy/MM/dd HH:mm").format(System.currentTimeMillis()), "yyyy/MM/dd HH:mm"));

                    if (startTime.after(currentTime)) {
                        contestVO.setStatus(ContestStatus.NOT_START);
                    }
                    else if (endTime.before(currentTime)) {
                        contestVO.setStatus(ContestStatus.DONE);
                    } else {
                        contestVO.setStatus(ContestStatus.RUNNING);
                    }
                } catch (Exception err) {
                    throw new RuntimeException(err);
                }
                contestVOs.add(contestVO);
            }
            Collections.sort(contestVOs, new Comparator<ContestVO>() {
                @Override
                public int compare(ContestVO o1, ContestVO o2) {
                    if (o1.getStatus().getValue() < o2.getStatus().getValue()) {
                        return -1;
                    }
                    else if (o1.getStatus().getValue() > o2.getStatus().getValue()) {
                        return 1;
                    } else {
                        return o1.getId() < o2.getId() ? -1 : (o1.getId() == o2.getId() ? 0 : 1);
                    }
                }
            });
        } else {
            LOG.warning("contests is empty");
        }
        return contestVOs;
    }
}
