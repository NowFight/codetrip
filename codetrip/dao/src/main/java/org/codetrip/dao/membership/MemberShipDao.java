package org.codetrip.dao.membership;

import org.codetrip.model.membership.MembershipModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface MemberShipDao {
    /**
     * 添加关系
     *
     * @param member
     * @return boolean
     * */
    public boolean insertNew(MembershipModel member);

    /**
     * 解除关系
     *
     * @param member
     * @return boolean
     * */
    public boolean deleteByMember(MembershipModel member);

    /**
     * 通过team ID查询成员
     *
     * @param teamId
     * @return List
     * */
    public List<MembershipModel> queryByTeamId(int teamId);

    /**
     * 通过user ID查询成员
     *
     * @param userId
     * @return List
     * */
    public List<MembershipModel> queryByUserId(int userId);
}
