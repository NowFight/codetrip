package org.codetrip.service.user;

import org.codetrip.common.vo.UserVO;
import org.codetrip.model.user.UserModel;

/**
 * Created by RuFeng on 2015/2/10.
 */
public interface UserService {
    /**
     * 登录
     *
     * @param user
     * @return UserVO
     * */
    public UserVO login(UserModel user);

    /**
     * 注册
     *
     * @param user
     * @return UserVO
     * */
    public UserVO registe(UserModel user);
}
