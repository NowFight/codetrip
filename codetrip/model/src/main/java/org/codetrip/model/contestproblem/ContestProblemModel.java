package org.codetrip.model.contestproblem;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/2/13.
 */
public class ContestProblemModel extends BaseModel {

    /*
    * 比赛ID
    * */
    private Integer contestId;

    /*
    * 题目ID
    * */
    private Integer problemId;

    //setter & getter


    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }
}
