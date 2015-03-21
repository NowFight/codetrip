package org.codetrip.dao.rank;

import org.codetrip.model.rank.RankModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public class RankDaoImpTester {
    private RankDao rankDao;

    @Before
    public void init() {
        BeanFactory factory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        rankDao = (RankDao) factory.getBean("RankDao");
    }

    @Test
    public void testInsertNew() {
        RankModel rank = new RankModel();
        rank.setContestId(1);
        rank.setTeamId(1);
        rank.setPenalty(1);
        if (rankDao.insertNew(rank)) {
            System.out.println("new rank id = " + rank.getRankId());
        }
    }

    @Test
    public void testQueryByTeamIdAndContestId() {
        if (rankDao.queryByTeamIdAndContestId(1, 1) != null) {
            System.out.println("query ok");
        }
    }

    @Test
    public void testQueryByContestId() {
        List<RankModel> ranks = rankDao.queryByContestId(1);
        if (ranks != null) {
            for (RankModel rank : ranks) {
                System.out.println(rank.getRankId() + " : " + rank.getTeamId());
            }
        }
    }

    @Test
    public void testUpdateByTeamIdAndRankId() {
        RankModel rank = new RankModel();
        rank.setPenalty(10);
        if (rankDao.updateByTeamIdAndContestId(1, 1, rank)) {
            System.out.println("update ok");
        }
    }
}
