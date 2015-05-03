package org.codetrip.common.vo;

import org.codetrip.common.so.ProblemStatisticSO;

import java.util.List;

/**
 * Created by RuFeng on 2015/4/29.
 */
public class RankVO {
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

    /*
    * team name
    * */
    private String teamName;

    /*
    * 做题记录
    * */
    private List<ProblemStatisticVO> problemStatisticVOs;
    // setter & getter


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<ProblemStatisticVO> getProblemStatisticVOs() {
        return problemStatisticVOs;
    }

    public void setProblemStatisticVOs(List<ProblemStatisticVO> problemStatisticVOs) {
        this.problemStatisticVOs = problemStatisticVOs;
    }

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
