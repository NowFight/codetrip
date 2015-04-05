package org.codetrip.dao.user;

import org.codetrip.common.enumerate.Gender;
import org.codetrip.common.enumerate.Nationality;
import org.codetrip.common.enumerate.Role;
import org.codetrip.common.so.UserSO;
import org.codetrip.model.user.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

/**
 * Created by RuFeng on 2015/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class UserDaoImpTester {

    @Autowired
    private UserDao userDao;

    @Test
    @Rollback(value = true)
    public void test() {
        UserSO userSO = new UserSO();
        UserModel user = new UserModel();
        user.setPassword("balabala");
        user.setEmail("balabala");
        user.setSex(Gender.MALE);
        user.setAge(1);
        user.setRegisteDate(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));
        user.setNationality(Nationality.CHINA);
        user.setPublication(Boolean.FALSE);
        user.setRole(Role.MEMBER);
        userDao.insert(user);
        userDao.findBySO(userSO);
        userDao.update(user);
    }
}
