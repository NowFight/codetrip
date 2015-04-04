package org.codetrip.dao.user;

import org.codetrip.common.so.UserSO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        userDao.findBySO(userSO);
    }
}
