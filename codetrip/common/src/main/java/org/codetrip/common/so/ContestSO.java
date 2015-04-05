package org.codetrip.common.so;

/**
 * Created by RuFeng on 2015/4/5.
 */
public class ContestSO {
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

    public Boolean getPrivatable() {
        return privation;
    }

    public void setPrivatable(Boolean privation) {
        this.privation = privation;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
