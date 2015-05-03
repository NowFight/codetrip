package org.codetrip.service.rank;

import org.codetrip.common.enumerate.JudgeResult;
import org.codetrip.common.vo.RankVO;

import java.util.List;

/**
 * Created by RuFeng on 2015/4/29.
 */
public interface RankService {
    /**
     * 列出比赛中的rank
     *
     * @param contestId
     * @return List
     * */
    public List<RankVO> listContestRank(Long contestId);

    /**
     * 对队伍计算rank值
     *
     * @param teamId
     * @param contestId
     * @param status
     * */
    public void caculateRankValue(Long teamId, Long contestId, JudgeResult status);
}
