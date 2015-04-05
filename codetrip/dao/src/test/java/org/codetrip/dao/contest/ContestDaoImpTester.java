package org.codetrip.dao.contest;

import org.codetrip.common.so.ContestSO;
import org.codetrip.model.contest.ContestModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class ContestDaoImpTester {
    @Autowired
    private ContestDao contestDao;

    @Test
    @Rollback(value = true)
    public void test() {
        ContestModel contest = new ContestModel();
        contest.setTitle("balabala");
        contest.setPassword("balabala");
        contest.setUserId(1L);
        contest.setStartTime(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));
        contest.setEndTime(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));
        contest.setPrivatable(Boolean.FALSE);
        contest.setCreateDate(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));

        contestDao.insert(contest);
        contestDao.find(contest.getId());
        ContestSO so = new ContestSO();
        so.setPassword("balabala");
        contestDao.findBySO(so);
        contestDao.update(contest);
    }
}
