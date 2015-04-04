package org.codetrip.dao.user;

import org.codetrip.common.so.UserSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.user.UserModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/3.
 */
public interface UserDao extends Dao<UserModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<UserModel> findBySO(UserSO so);
}
