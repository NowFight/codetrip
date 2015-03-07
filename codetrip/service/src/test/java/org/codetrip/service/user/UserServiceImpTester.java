package org.codetrip.service.user;

import org.codetrip.model.user.UserModel;
import org.codetrip.service.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by RuFeng on 2015/2/10.
 */
public class UserServiceImpTester {
    private UserService userService;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        userService = (UserService) beanFactory.getBean("UserService");
    }

    //@Test
    public void testInsertUser() {
        UserModel user = new UserModel();

        user.setUserId(0);
        user.setPassword("rufeng");
        user.setNikeName("NowFight");
        user.setEmail("rufengemacs@gmail.com");
        user.setNationality("China");
        user.setPublicInfo("YES");
        user.setAge(22);
        user.setSex("male");
        user.setRegisterDate("2015/2/3");
        user.setRole("MEMBER");

        if (userService.insertUser(user)) {
            System.out.println("insert user success");
        } else {
            System.out.println("insert user false");
        }
    }

    //@Test
    public void testQueryUserByEmailAndPassword() {
        UserModel user = userService.queryUserByEmailAndPassword("rufengemacs@gmail.com", "rufeng");
        if (user != null) {
            System.out.println("email = " + user.getEmail());
            System.out.println("password = " + user.getPassword());
        }
    }

    @Test
    public void testQueryUserByEmail() {
        UserModel user = userService.queryUserByEmail("rufengeacs@gmail.com");
        if (user == null) {
            System.out.println("user not exists");
        } else {
            System.out.println("email = " + user.getEmail());
        }
    }
}
