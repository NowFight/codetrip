package org.codetrip.dao.membership;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.membership.MembershipModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository("MemberShipDao")
public class MemberShipDaoImp extends BaseDao implements MemberShipDao {
    /**
     * 添加关系
     *
     * @param member
     * @return boolean
     */
    @Override
    public boolean insertNew(MembershipModel member) {
        if (getSession().insert(getMapperPrefix() + ".insertNew", member) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 解除关系
     *
     * @param member
     * @return boolean
     */
    @Override
    public boolean deleteByMember(MembershipModel member) {
        if (getSession().delete(getMapperPrefix() + ".deleteByMember", member) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过team ID查询成员
     *
     * @param teamId
     * @return List
     */
    @Override
    public List<MembershipModel> queryByTeamId(int teamId) {
        List<MembershipModel> members = getSession().selectList(getMapperPrefix() + ".queryByTeamId", teamId);
        if (members.isEmpty()) {
            return null;
        } else {
            return members;
        }
    }

    /**
     * 通过user ID查询成员
     *
     * @param userId
     * @return List
     */
    @Override
    public List<MembershipModel> queryByUserId(int userId) {
        List<MembershipModel> members = getSession().selectList(getMapperPrefix() + ".queryByTeamId", userId);
        if (members.isEmpty()) {
            return null;
        } else {
            return members;
        }
    }
}
