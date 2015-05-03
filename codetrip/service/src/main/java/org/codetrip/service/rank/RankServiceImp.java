package org.codetrip.service.rank;

import org.codetrip.common.enumerate.JudgeResult;
import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.common.so.RankSO;
import org.codetrip.common.vo.ContestProblemVO;
import org.codetrip.common.vo.ProblemStatisticVO;
import org.codetrip.common.vo.RankVO;
import org.codetrip.dao.contestproblem.ContestProblemDao;
import org.codetrip.dao.participant.ParticipantDao;
import org.codetrip.dao.rank.RankDao;
import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.codetrip.model.participant.ParticipantModel;
import org.codetrip.model.rank.RankModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.service.contestproblem.ContestProblemService;
import org.codetrip.service.participator.ParticipatorService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/29.
 */
@Service
public class RankServiceImp implements RankService {
    public static final Logger LOG = Logger.getLogger(RankService.class.getName());

    @Autowired
    private RankDao rankDao;

    @Autowired
    private ParticipantDao participantDao;

    @Autowired
    private ProblemStatisticDao problemStatisticDao;

    @Autowired
    private ContestProblemDao contestProblemDao;

    @Autowired
    private Mapper dozerMapper;
    /**
     * 列出比赛中的rank
     *
     * @param contestId
     * @return List
     */
    @Override
    public List<RankVO> listContestRank(Long contestId) {
        RankSO so = new RankSO();
        so.setContestId(contestId);
        List<RankModel> ranks = rankDao.findBySO(so);
        List<RankVO> rankVOs = new ArrayList<RankVO>();
        for (RankModel rank : ranks) {
            RankVO vo = dozerMapper.map(rank, RankVO.class);
            ParticipantModel participant = participantDao.find(vo.getTeamId());
            if (participant == null) {
                vo.setTeamName("Unknown");
                LOG.warning("participant is null with team id = " + vo.getTeamId());
            } else {
                vo.setTeamName(participant.getTeamName());
            }

            ContestProblemSO cso = new ContestProblemSO();
            cso.setContestId(contestId);
            List<ContestProblemModel> contestProblems = contestProblemDao.findBySO(cso);

            List<ProblemStatisticVO> problemStatisticVOs = new ArrayList<ProblemStatisticVO>();

            Collections.sort(contestProblems, new Comparator<ContestProblemModel>() {
                @Override
                public int compare(ContestProblemModel o1, ContestProblemModel o2) {
                    return o1.getId() < o2.getId() ? -1 : (o1.getId() == o2.getId() ? 0 : 1);
                }
            });

            for (ContestProblemModel contestProblem : contestProblems) {
                ProblemStatisticSO pso = new ProblemStatisticSO();
                pso.setContestId(contestId);
                pso.setProblemId(contestProblem.getProblemId());
                List<ProblemStatisticModel> statistics = problemStatisticDao.findBySO(pso);
                if (!statistics.isEmpty()) {
                    problemStatisticVOs.add(dozerMapper.map(statistics.get(0), ProblemStatisticVO.class));
                }
            }

            vo.setProblemStatisticVOs(problemStatisticVOs);

            rankVOs.add(vo);

        }
        return rankVOs;
    }

    /**
     * 对队伍计算rank值
     *
     * @param teamId
     * @param contestId
     * @param status
     */
    @Override
    public void caculateRankValue(Long teamId, Long contestId, JudgeResult status) {
        RankSO so = new RankSO();
        so.setContestId(contestId);
        List<RankModel> ranks = rankDao.findBySO(so);
        if (!ranks.isEmpty()) {
            RankModel rank = ranks.get(0);
            if (!status.equals(JudgeResult.ACCEPT)) {
                rank.setPenalty(rank.getPenalty() + 20);
            }
            rankDao.update(rank);
        } else {
            //创建rank记录
            RankModel rank = new RankModel();
            if (!status.equals(JudgeResult.ACCEPT)) {
                rank.setPenalty(20L);
            } else {
                rank.setPenalty(0L);
            }
            rank.setTeamId(teamId);
            rank.setContestId(contestId);
            rankDao.insert(rank);
        }
    }
}
