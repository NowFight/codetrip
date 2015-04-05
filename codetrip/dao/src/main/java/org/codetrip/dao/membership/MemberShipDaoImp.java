package org.codetrip.dao.membership;

import org.codetrip.common.so.MemberShipSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.membership.MembershipModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository
public class MemberShipDaoImp extends BaseDao<MembershipModel> implements MemberShipDao {
    private final static Logger LOG = Logger.getLogger(MemberShipDao.class.getName());

    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<MembershipModel> findBySO(MemberShipSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }

    /**
     * 条件删除
     *
     * @param so
     */
    @Override
    public void deleteBySO(MemberShipSO so) {
        int row = getSession().delete(getNamespace() + ".deleteBySO", so);
        if (row == 0) {
            LOG.warning("no row deleted!");
        }
    }
}
