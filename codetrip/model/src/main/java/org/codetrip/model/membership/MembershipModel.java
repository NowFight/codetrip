package org.codetrip.model.membership;

import org.codetrip.model.BaseModel;

/**
 * Created by RuFeng on 2015/1/29.
 */
public class MembershipModel extends BaseModel {

    /*
    * 队伍编号
    * */
    private Integer teamId;

    /*
    * 用户编号
    * */
    private Integer userId;

    // setter & getter


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
