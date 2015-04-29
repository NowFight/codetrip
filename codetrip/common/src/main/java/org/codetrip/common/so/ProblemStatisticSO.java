package org.codetrip.common.so;

/**
 * Created by RuFeng on 2015/4/5.
 */
public class ProblemStatisticSO {
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

    //setter & getter


    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

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
