package org.codetrip.common.so;

/**
 * Created by RuFeng on 2015/4/5.
 */
public class RankSO {
    /*
    * rank ID
    * */
    private Long id;

    /*
    * team ID
    * */
    private Long teamId;

    /*
    * 比赛编号
    * */
    private Long contestId;

    /*
    * 罚时
    * */
    private Long penalty;

    // setter & getter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getPenalty() {
        return penalty;
    }

    public void setPenalty(Long penalty) {
        this.penalty = penalty;
    }
}
