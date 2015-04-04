package org.codetrip.dao.user;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.user.UserModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuFeng on 2015/2/3.
 */
@Repository("UserDao")
public class UserDaoImp extends BaseDao implements UserDao {

    /**
     * 添加用户
     *
     * @param user
     * @return boolean
     */
    @Override
    public boolean insertUser(UserModel user) {
        int affect = getSession().insert(getNamespace() + ".insertUser", user);
        if (affect == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过email和password查询用户
     *
     * @param email
     * @param password
     * @return UserModel
     */
    @Override
    public UserModel queryUserByEmailAndPassword(String email, String password) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("email", email);
        map.put("password", password);

        List<UserModel> userList = getSession().selectList(getNamespace() + ".queryUserByEmailAndPassword", map);
        if (userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * 通过email查询用户
     *
     * @param email
     * @return UserModel
     * */
    @Override
    public UserModel queryUserByEmail(String email) {
        List<UserModel> userList = getSession().selectList(getNamespace() + ".queryUserByEmail", email);
        if (userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * 通过UserId查询user
     *
     * @param userId
     * @return UserModel
     */
    @Override
    public UserModel queryUserByUserId(int userId) {
        return getSession().selectOne(getNamespace() + ".queryUserByUserId", userId);
    }
}
