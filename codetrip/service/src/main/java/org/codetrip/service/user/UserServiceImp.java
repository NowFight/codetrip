package org.codetrip.service.user;

import org.codetrip.dao.user.UserDao;
import org.codetrip.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by RuFeng on 2015/2/10.
 */
@Service("UserService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 添加用户
     * @param user
     * @retuan boolean
     * */
    @Override
    public boolean insertUser(UserModel user) {
        if (userDao.insertUser(user)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过email和password查询用户
     * @param email
     * @param password
     * @return UserModel
     * */
    @Override
    public UserModel queryUserByEmailAndPassword(String email, String password) {
        return userDao.queryUserByEmailAndPassword(email, password);
    }

    /**
     * 通过email查询用户
     * @param email
     * @return UserModel
     * */
    @Override
    public UserModel queryUserByEmail(String email) {
        return userDao.queryUserByEmail(email);
    }

    /**
     * 通过UserId查询user
     *
     * @param userId
     * @return UserModel
     */
    @Override
    public UserModel queryUserByUserId(int userId) {
        return userDao.queryUserByUserId(userId);
    }
}