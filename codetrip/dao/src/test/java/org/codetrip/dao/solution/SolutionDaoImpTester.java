package org.codetrip.dao.solution;

import org.codetrip.common.enumerate.Language;
import org.codetrip.common.so.SolutionSO;
import org.codetrip.model.solution.SolutionModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by RuFeng on 2015/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class SolutionDaoImpTester {

    @Autowired
    private SolutionDao solutionDao;

    @Test
    @Rollback(value = true)
    public void test() {
        SolutionModel solution = new SolutionModel();
        solution.setProblemId(1L);
        solution.setDate(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));
        solution.setLanguage(Language.C);
        solution.setCodeContext("balabala");
        solutionDao.insert(solution);
        solutionDao.find(solution.getId());
        SolutionSO so = new SolutionSO();
        so.setId(solution.getId());
        solutionDao.findBySO(so);
        solutionDao.update(solution);
    }
}
