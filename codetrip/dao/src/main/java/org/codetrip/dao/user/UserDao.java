package org.codetrip.dao.user;

import org.codetrip.model.user.UserModel;

/**
 * Created by RuFeng on 2015/2/3.
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user
     * @return boolean
     */
    public boolean insertUser(UserModel user);

    /**
     * 通过email和password查询用户
     *
     * @param email
     * @param password
     * @return UserModel
     * */
    public UserModel queryUserByEmailAndPassword(String email, String password);

    /**
     * 通过email查询用户
     *
     * @param email
     * @return UserModel
     * */
    public UserModel queryUserByEmail(String email);

    /**
     * 通过UserId查询user
     *
     * @param userId
     * @return UserModel
     * */
    public UserModel queryUserByUserId(int userId);
}
