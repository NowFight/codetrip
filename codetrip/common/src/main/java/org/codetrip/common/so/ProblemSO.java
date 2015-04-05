package org.codetrip.common.so;

/**
 * Created by RuFeng on 2015/4/5.
 */
public class ProblemSO {
    /*
    * 题目编号
    * */
    private Long id;

    /*
    * 用户ID
    * */
    private Long userId;

    /*
    * 比赛ID
    * */
    private Long contestId;

    /*
    * 标题
    * */
    private String title;

    /*
    * 描述信息
    * */
    private String description;

    /*
    * 输入描述
    * */
    private String inputDescription;

    /*
    * 输出描述
    * */
    private String outputDescription;

    /*
    * 输入案例
    * */
    private String sampleInput;

    /*
    * 输出案例
    * */
    private String sampleOutput;

    /*
    * 备注
    * */
    private String hint;

    /*
    * 出处
    * */
    private String source;

    /*
    * 是否是special Judge
    * 值为 YES / NO
    * */
    private Boolean specialJudge;

    /*
    * 可见性
    * 值为 YES / NO
    * */
    private Boolean visible;

    /*
    * 内存限制，单位为KB
    *
    * */
    private Integer memoryLimit;

    /*
    * 时间限制，单位为MS
    * */
    private Integer timeLimit;

    //setter & getter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    public String getOutputDescription() {
        return outputDescription;
    }

    public void setOutputDescription(String outputDescription) {
        this.outputDescription = outputDescription;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getSpecialJudge() {
        return specialJudge;
    }

    public void setSpecialJudge(Boolean specialJudge) {
        this.specialJudge = specialJudge;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }
}
