package org.codetrip.model.rank;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class RankModel extends BaseModel {

    /*
    * rank ID
    * */
    private Integer rankId;

    /*
    * team ID
    * */
    private Integer teamId;

    /*
    * 比赛编号
    * */
    private Integer contestId;

    /*
    * 罚时
    * */
    private Integer penalty;

    // setter & getter


    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
