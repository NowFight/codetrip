package org.codetrip.dao.user;

import org.codetrip.common.so.UserSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.user.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/3.
 */
@Repository
public class UserDaoImp extends BaseDao<UserModel> implements UserDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<UserModel> findBySO(UserSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}