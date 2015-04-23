package org.codetrip.common.vo;

import org.codetrip.common.enumerate.ContestStatus;

/**
 * Created by RuFeng on 2015/4/20.
 */
public class ContestVO {

    /*
    * 比赛编号
    * */
    private Long id;

    /*
    * 用户ID
    * */
    private Long userId;

    /*
    * 比赛标题
    * */
    private String title;

    /*
    * 创建时间
    * 格式为：YYYY-MM-DD-HH-MM-SS
    * */
    private String createDate;

    /*
    * 开始时间
    * 格式为：YYYY-MM-DD-HH-MM-SS
    * */
    private String startTime;

    /*
    * 结束时间
    * 格式为：YYYY-MM-DD-HH-MM-SS
    * */
    private String endTime;

    /*
    * 是否是私有的
    * 值为：YES / NO
    * */
    private Boolean privation;

    /*
    * 比赛密码，需要加密
    * */
    private String password;

    /*
    * 题目数
    * */
    private Integer problems;

    /*
    * 参加的队伍数
    * */
    private Long participators;

    /*
    * 比赛是否已经开始
    * */
    private ContestStatus status;

    public Boolean isDone() {
        if (status.equals(ContestStatus.DONE))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public Boolean isRunning() {
        if (status.equals(ContestStatus.RUNNING))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public Boolean notStart() {
        if (status.equals(ContestStatus.NOT_START))
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    //setter & getter


    public ContestStatus getStatus() {
        return status;
    }

    public void setStatus(ContestStatus status) {
        this.status = status;
    }

    public Integer getProblems() {
        return problems;
    }

    public void setProblems(Integer problems) {
        this.problems = problems;
    }

    public Long getParticipators() {
        return participators;
    }

    public void setParticipators(Long participators) {
        this.participators = participators;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getPrivation() {
        return privation;
    }

    public void setPrivation(Boolean privation) {
        this.privation = privation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
