package org.codetrip.common.so;

import org.codetrip.common.enumerate.JudgeResult;
import org.codetrip.common.enumerate.Language;

/**
 * Created by RuFeng on 2015/4/5.
 */
public class SolutionSO {
    /*
    * solution ID
    * */
    private Long id;

    /*
    * 队伍编号
    * */
    private Long teamId;

    /*
    * 题目ID
    * */
    private Long ProblemId;

    /*
    * 用户ID
    * */
    private Long userId;

    /*
    * 比赛编号
    * */
    private Long contestId;

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

    public Long getProblemId() {
        return ProblemId;
    }

    public void setProblemId(Long problemId) {
        ProblemId = problemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
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
