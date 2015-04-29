package org.codetrip.common.vo;

import java.util.List;

/**
 * Created by RuFeng on 2015/4/27.
 */
public class ParticipantVO {
    /*
    * 队伍编号
    * */
    private Long id;

    /*
    * 比赛编号
    * */
    private Long contestId;

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
    private String registeDate;

    /*
    * 队伍成员
    * */
    private List<String> members;

    // setter & getter


    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
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

    public String getRegisteDate() {
        return registeDate;
    }

    public void setRegisteDate(String registeDate) {
        this.registeDate = registeDate;
    }
}
