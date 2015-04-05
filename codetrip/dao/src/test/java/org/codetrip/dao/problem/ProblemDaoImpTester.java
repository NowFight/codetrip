package org.codetrip.dao.problem;

import org.codetrip.common.so.ProblemSO;
import org.codetrip.model.problem.ProblemModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by RuFeng on 2015/2/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class ProblemDaoImpTester {

    @Autowired
    private ProblemDao problemDao;

    @Test
    @Rollback(value = true)
    public void test() {
        ProblemModel problem = new ProblemModel();
        problem.setMemoryLimit(65536);
        problem.setTimeLimit(1);
        problem.setTitle("balabala");
        problem.setContestId(1L);
        problem.setVisible(Boolean.TRUE);
        problem.setDescription("balabala");
        problem.setInputDescription("balabala");
        problem.setOutputDescription("balabala");
        problem.setSampleInput("balabala");
        problem.setSampleOutput("balabala");
        problem.setSpecialJudge(Boolean.FALSE);
        problem.setUserId(1L);

        problemDao.insert(problem);
        problemDao.find(problem.getId());
        ProblemSO so = new ProblemSO();
        so.setSpecialJudge(Boolean.TRUE);
        problemDao.findBySO(so);
        problemDao.update(problem);
    }
}
