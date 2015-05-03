package org.codetrip.common.vo;

/**
 * Created by RuFeng on 2015/5/3.
 */
public class ProblemStatisticVO {
    /*
    * 序号
    * */
    private Long id;

    /*
    * 题目编号
    * */
    private Long problemId;

    /*
    * 比赛编号
    * */
    private Long contestId;

    /*
    * 总提交数
    * */
    private Integer submissions;

    /*
    * 通过提交数
    * */
    private Integer accept;

    /*
    * 编译错误数
    * */
    private Integer compileError;

    /*
    * WA次数
    * */
    private Integer wrongAnswer;

    /*
    * 超时数
    * */
    private Integer timeLimitError;

    /*
    * 超内存数
    * */
    private Integer memLimitError;

    /*
    * 格式错误数
    * */
    private Integer presentationError;

    /*
    * 运行时错误数
    * */
    private Integer runtimeError;

    /*
    * 输出受限数
    * */
    private Integer outputLimitError;

    //统计值初始化为0
    public void init() {
        submissions = 0;
        accept = 0;
        compileError = 0;
        wrongAnswer = 0;
        timeLimitError = 0;
        memLimitError = 0;
        presentationError = 0;
        runtimeError = 0;
        outputLimitError = 0;
    }

    //setter & getter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Integer getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Integer submissions) {
        this.submissions = submissions;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getCompileError() {
        return compileError;
    }

    public void setCompileError(Integer compileError) {
        this.compileError = compileError;
    }

    public Integer getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(Integer wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public Integer getTimeLimitError() {
        return timeLimitError;
    }

    public void setTimeLimitError(Integer timeLimitError) {
        this.timeLimitError = timeLimitError;
    }

    public Integer getMemLimitError() {
        return memLimitError;
    }

    public void setMemLimitError(Integer memLimitError) {
        this.memLimitError = memLimitError;
    }

    public Integer getPresentationError() {
        return presentationError;
    }

    public void setPresentationError(Integer presentationError) {
        this.presentationError = presentationError;
    }

    public Integer getRuntimeError() {
        return runtimeError;
    }

    public void setRuntimeError(Integer runtimeError) {
        this.runtimeError = runtimeError;
    }

    public Integer getOutputLimitError() {
        return outputLimitError;
    }

    public void setOutputLimitError(Integer outputLimitError) {
        this.outputLimitError = outputLimitError;
    }
}
