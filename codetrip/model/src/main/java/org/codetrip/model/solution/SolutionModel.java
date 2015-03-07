package org.codetrip.model.solution;

import org.codetrip.common.enumerate.JudgeResult;
import org.codetrip.common.enumerate.Language;
import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class SolutionModel extends BaseModel {

    /*
    * solution ID
    * */
    private Integer solutionId;

    /*
    * 队伍编号
    * */
    private Integer teamId;

    /*
    * 题目ID
    * */
    private Integer ProblemId;

    /*
    * 用户ID
    * */
    private Integer userId;

    /*
    * 比赛编号
    * */
    private Integer contestId;

    /*
    * 耗时
    * */
    private Integer useTime;

    /*
    * 内存消耗
    * */
    private Integer useMemory;

    /*
    * 提交时间
    * */
    private String date;

    /*
    * 提交语言
    * */
    private Language language;

    /*
    * 结果
    * */
    private JudgeResult result;

    /*
    * 编译输出
    * */
    private String compileOutput;

    /*
    * 代码文本
    * */
    private String codeContext;

    //setter & getter


    public Integer getProblemId() {
        return ProblemId;
    }

    public void setProblemId(Integer problemId) {
        ProblemId = problemId;
    }

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Integer getUseMemory() {
        return useMemory;
    }

    public void setUseMemory(Integer useMemory) {
        this.useMemory = useMemory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public JudgeResult getResult() {
        return result;
    }

    public void setResult(JudgeResult result) {
        this.result = result;
    }

    public String getCompileOutput() {
        return compileOutput;
    }

    public void setCompileOutput(String compileOutput) {
        this.compileOutput = compileOutput;
    }

    public String getCodeContext() {
        return codeContext;
    }

    public void setCodeContext(String codeContext) {
        this.codeContext = codeContext;
    }
}
