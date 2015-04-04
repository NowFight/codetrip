package org.codetrip.dao.testcase;

import org.codetrip.common.so.TestCaseSO;
import org.codetrip.model.testcase.TestCaseModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class TestCaseDaoImpTester {
    @Autowired
    private TestCaseDao testCaseDao;

    @Test
    @Rollback(value = true)
    public void test() {
        TestCaseModel testcase = new TestCaseModel();
        testcase.setProblemId(1L);
        testcase.setStandardOutput("output");
        testcase.setTestData("input");
        testCaseDao.insert(testcase);
        testCaseDao.find(testcase.getId());
        TestCaseSO testCaseSO = new TestCaseSO();
        testCaseSO.setProblemId(1L);
        testCaseDao.findBySO(testCaseSO);
    }
}
