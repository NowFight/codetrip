package org.codetrip.model.testcase;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class TestCaseModel extends BaseModel {

    /*
    * 案例编号
    * */
    private Integer caseNumber;

    /*
    * 题目编号
    * */
    private Integer problemId;

    /*
    * 测试数据
    * */
    private String testData;

    /*
    * 标准输出结果
    * */
    private String standardOutput;

    //setter & getter


    public Integer getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(Integer caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getStandardOutput() {
        return standardOutput;
    }

    public void setStandardOutput(String standardOutput) {
        this.standardOutput = standardOutput;
    }
}
