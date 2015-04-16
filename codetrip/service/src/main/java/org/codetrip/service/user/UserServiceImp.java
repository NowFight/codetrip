package org.codetrip.service.user;

import org.codetrip.common.so.UserSO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.dao.user.UserDao;
import org.codetrip.model.user.UserModel;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/2/10.
 */
@Service
public class UserServiceImp implements UserService {
    private final static Logger LOG = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapper dozerMapper;

    /**
     * 登录
     *
     * @param user
     * @return UserVO
     */
    @Override
    public UserVO login(UserModel user) {
        if (user == null) {
            LOG.warning("login - user is null");
            return null;
        }
        UserSO so = new UserSO();
        so.setEmail(user.getEmail());
        so.setPassword(user.getPassword());
        List<UserModel> users = userDao.findBySO(so);

        if (users != null && !users.isEmpty()) {
            UserVO userVO = dozerMapper.map(users.get(0), UserVO.class);
            userVO.setLogined(Boolean.TRUE);
            return userVO;
        } else {
            LOG.warning(String.format("login - login failed with email = {0}", user.getEmail()));
            UserVO userVO = new UserVO();
            userVO.setLogined(Boolean.FALSE);
            return userVO;
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return UserVO
     */
    @Override
    public UserVO registe(UserModel user) {
        if (user == null) {
            LOG.warning("registe - user is null");
            return null;
        }

        UserVO userVO = new UserVO();
        if (checkUser(user)) {
            userDao.insert(user);
            userVO = dozerMapper.map(user, UserVO.class);
            userVO.setLogined(Boolean.TRUE);
            userVO.setRegisteSuccess(Boolean.TRUE);
        } else {
            userVO.setLogined(Boolean.FALSE);
            userVO.setRegisteSuccess(Boolean.FALSE);
        }
        return userVO;
    }

    /**
     * 检查用户是否已经存在
     *
     * true - 用户不存在
     * false - 用户存在
     *
     * @param user
     * @return boolean
     * */
    public boolean checkUser(UserModel user) {
        UserSO so = new UserSO();
        so.setEmail(user.getEmail());

        List<UserModel> users = userDao.findBySO(so);

        if (users.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}