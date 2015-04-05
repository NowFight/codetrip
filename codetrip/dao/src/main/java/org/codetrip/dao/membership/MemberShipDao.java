package org.codetrip.dao.membership;

import org.codetrip.common.so.MemberShipSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.membership.MembershipModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface MemberShipDao extends Dao<MembershipModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<MembershipModel> findBySO(MemberShipSO so);

    /**
     * 条件删除
     *
     * @param so
     * */
    public void deleteBySO(MemberShipSO so);
}
