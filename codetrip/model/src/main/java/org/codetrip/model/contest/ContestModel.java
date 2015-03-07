package org.codetrip.model.contest;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class ContestModel extends BaseModel {

    /*
    * 比赛编号
    * */
    private Integer contestId;

    /*
    * 用户ID
    * */
    private Integer userId;

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
    private String privation;

    /*
    * 比赛密码，需要加密
    * */
    private String password;

    //setter & getter


    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public String getPrivation() {
        return privation;
    }

    public void setPrivation(String privation) {
        this.privation = privation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
