package org.codetrip.common.so;

/**
 * Created by RuFeng on 2015/4/4.
 */
public class TestCaseSO {
    /*
    * 案例编号
    * */
    private Long id;

    /*
    * 题目编号
    * */
    private Long problemId;

    /*
    * 测试数据
    * */
    private String testData;

    /*
    * 标准输出结果
    * */
    private String standardOutput;

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
