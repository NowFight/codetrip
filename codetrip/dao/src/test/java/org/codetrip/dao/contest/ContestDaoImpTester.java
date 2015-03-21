package org.codetrip.dao.contest;

import org.codetrip.model.contest.ContestModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
public class ContestDaoImpTester {
    private ContestDao contestDao;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        contestDao = (ContestDao) beanFactory.getBean("ContestDao");
    }

    @Test
    public void testInsertContest() {
        ContestModel contest = new ContestModel();
        contest.setUserId(1);
        contest.setTitle("C1");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        contest.setCreateDate(formater.format(System.currentTimeMillis()));
        contest.setStartTime(formater.format(System.currentTimeMillis()));
        contest.setEndTime(formater.format(System.currentTimeMillis()));
        contest.setPassword("123456");
        contest.setPrivation("NO");

        if (contestDao.insertContest(contest)) {
            System.out.println("比赛添加成功 #" + contest.getContestId());
        }
    }

    @Test
    public void testQueryContestByContestId() {
        ContestModel contest = contestDao.queryContestByContestId(2);
        if (contest != null) {
            System.out.println("题目ID = " + contest.getContestId());
            System.out.println("题目标题 = " + contest.getTitle());
        }
    }

    @Test
    public void testUpdateContestByContestId() {
        ContestModel contest = new ContestModel();
        contest.setPassword("654321");
        contest.setTitle("C2");
        if (contestDao.updateContestByContestId(2, contest)) {
            System.out.println("更新成功");
        }
    }

    @Test
    public void testQueryAllContests() {
        List<ContestModel> contests = contestDao.queryAllContests();
        if (contests != null) {
            for (ContestModel contest : contests) {
                System.out.println("比赛题目 = " + contest.getTitle());
            }
        }
    }
}
