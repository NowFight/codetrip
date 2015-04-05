package org.codetrip.dao.rank;

import org.codetrip.common.so.RankSO;
import org.codetrip.model.rank.RankModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class RankDaoImpTester {
    @Autowired
    private RankDao rankDao;

    @Test
    @Rollback(value = true)
    public void test() {
        RankModel rank = new RankModel();
        rank.setContestId(1L);
        rank.setPenalty(1L);
        rank.setTeamId(1L);
        rankDao.insert(rank);
        rankDao.find(rank.getId());
        RankSO so = new RankSO();
        so.setId(rank.getId());
        rankDao.findBySO(so);
        rankDao.update(rank);
    }
}
