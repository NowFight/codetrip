package org.codetrip.dao.contestproblem;

import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by RuFeng on 2015/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class ContestProblemDaoImpTester {
    @Autowired
    private ContestProblemDao contestProblemDao;

    //@Test
    //@Rollback(value = true)
    public void test() {
        ContestProblemModel contestProblem = new ContestProblemModel();
        contestProblem.setContestId(1L);
        contestProblem.setProblemId(1L);
        contestProblemDao.insert(contestProblem);
        contestProblemDao.find(contestProblem.getId());
        ContestProblemSO so = new ContestProblemSO();
        so.setProblemId(1L);
        contestProblemDao.findBySO(so);
        contestProblemDao.delete(1L);
        contestProblemDao.deleteBySO(so);
    }

    @Test
    public void count() {
        System.out.println(contestProblemDao.count(1L));
    }
}