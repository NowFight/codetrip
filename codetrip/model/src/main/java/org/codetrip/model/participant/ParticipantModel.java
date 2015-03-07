package org.codetrip.model.participant;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class ParticipantModel extends BaseModel {

    /*
    * 队伍编号
    * */
    private Integer teamId;

    /*
    * 比赛编号
    * */
    private Integer contestId;

    /*
    * 队伍名
    * */
    private String teamName;

    /*
    * 密码
    * */
    private String password;

    /*
    * 注册时间，格式为：YYYY-MM-DD-HH-MM-SS
    * */
    private String registerDate;

    // setter & getter


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
