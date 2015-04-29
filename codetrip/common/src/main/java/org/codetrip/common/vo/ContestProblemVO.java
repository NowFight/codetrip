package org.codetrip.common.vo;

/**
 * Created by RuFeng on 2015/4/28.
 */
public class ContestProblemVO {
    /*
    * 序号
    * */
    private Long id;

    /*
    * 比赛ID
    * */
    private Long contestId;

    /*
    * 题目ID
    * */
    private Long problemId;

    //setter & getter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }
}
