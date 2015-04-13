package org.codetrip.service.user;

import org.codetrip.common.enumerate.Gender;
import org.codetrip.common.enumerate.Nationality;
import org.codetrip.common.enumerate.Role;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.user.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

/**
 * Created by RuFeng on 2015/2/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class UserServiceImpTester {
    @Autowired
    private UserService userService;

    @Test
    @Rollback(value = true)
    public void test() {
        UserModel user = new UserModel();
        user.setEmail("email");
        user.setPassword("password");
        user.setRegisteDate(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));
        user.setAge(1);
        user.setRole(Role.MEMBER);
        user.setSex(Gender.MALE);
        user.setNationality(Nationality.CHINA);
        user.setPublication(Boolean.FALSE);
        UserVO userVO = userService.registe(user);
        if (userVO != null && userVO.isLogined()) {
            System.out.println("注册成功!");
        }
        userVO = userService.login(user);
        if (userVO != null && userVO.isLogined()) {
            System.out.println("登录成功!");
        }
    }
}
