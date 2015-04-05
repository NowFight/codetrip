package org.codetrip.common.so;

/**
 * Created by RuFeng on 2015/4/5.
 */
public class MemberShipSO {
    /*
    * 编号
    * */
    private Long id;

    /*
    * 队伍编号
    * */
    private Long teamId;

    /*
    * 用户编号
    * */
    private Long userId;

    // setter & getter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
