package org.codetrip.dao.user;

import org.codetrip.model.user.UserModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by RuFeng on 2015/2/3.
 */
public class UserDaoImpTester {

    private UserDao userDao;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        userDao = (UserDao) beanFactory.getBean("UserDao");
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

        if (userDao.insertUser(user)) {
            System.out.println("Insert User Success");
        } else {
            System.out.println("Insert User False");
        }
    }

    @Test
    public void testQueryUserByEmailAndPassword() {
        UserModel user = userDao.queryUserByEmailAndPassword("rufengemacs@gmail.com", "rufeng");
        if (user == null) {
            System.out.println("user not exists");
        } else {
            System.out.println("email = " + user.getEmail());
            System.out.println("password = " + user.getPassword());
        }
    }

    @Test
    public void testQueryUserByEmail() {
        UserModel user = userDao.queryUserByEmail("rufengeacs@gmail.com");
        if (user == null) {
            System.out.println("user not exists");
        } else {
            System.out.println("email = " + user.getEmail());
        }
    }
}
