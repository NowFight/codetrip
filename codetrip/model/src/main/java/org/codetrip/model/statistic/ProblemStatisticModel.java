package org.codetrip.model.statistic;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class ProblemStatisticModel extends BaseModel {

    /*
    * 题目编号
    * */
    private Integer problemId;

    /*
    * 总提交数
    * */
    private Integer submissions = 0;

    /*
    * 通过提交数
    * */
    private Integer accept = 0;

    /*
    * 编译错误数
    * */
    private Integer compileError = 0;

    /*
    * WA次数
    * */
    private Integer wrongAnswer = 0;

    /*
    * 超时数
    * */
    private Integer timeLimitError = 0;

    /*
    * 超内存数
    * */
    private Integer memLimitError = 0;

    /*
    * 格式错误数
    * */
    private Integer presentationError = 0;

    /*
    * 运行时错误数
    * */
    private Integer runtimeError = 0;

    /*
    * 输出受限数
    * */
    private Integer outputLimitError = 0;

    /*
    * 系统错误
    * */
    private Integer systemError = 0;

    //setter & getter


    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getSubmissions() {
        return submissions;
    }

    public void setSubmissions(Integer submissions) {
        this.submissions = submissions;
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

    public Integer getSystemError() {
        return systemError;
    }

    public void setSystemError(Integer systemError) {
        this.systemError = systemError;
    }
}
