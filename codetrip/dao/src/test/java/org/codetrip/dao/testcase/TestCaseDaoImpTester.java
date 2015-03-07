package org.codetrip.dao.testcase;

import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.model.testcase.TestCaseModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
public class TestCaseDaoImpTester {
    private TestCaseDao testCaseDao;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        testCaseDao = (TestCaseDao) beanFactory.getBean("TestCaseDao");
    }

    @Test
    public void testInsertTestCase() {
        TestCaseModel testcase = new TestCaseModel();
        testcase.setCaseNumber(1);
        testcase.setProblemId(1);
        testcase.setTestData("1 1");
        testcase.setStandardOutput("2");

        if (testCaseDao.insertTestCase(testcase)) {
            System.out.println("insert Success");
        } else {
            System.out.println("insert fault");
        }
    }

    @Test
    public void testUpdateTestCaseByProblemIdAndCaseId() {
        TestCaseModel testcase = new TestCaseModel();
        testcase.setStandardOutput("4");
        testcase.setTestData("2 2");
        if (testCaseDao.updateTestCaseByProblemIdAndCaseId(1, 1, testcase)) {
            System.out.println("update success");
        } else {
            System.out.println("update fault");
        }
    }

    @Test
    public void testQueryTestCaseByProblemId() {
        List<TestCaseModel> testcases = testCaseDao.queryTestCaseByProblemId(1);
        if (testcases != null) {
            for (TestCaseModel testcase : testcases) {
                System.out.println(testcase.getTestData() + " : " + testcase.getStandardOutput());
            }
        }
    }

    @Test
    public void testDeleteTestCaseByProblemIdAndCaseId() {
        if (testCaseDao.deleteTestCaseByProblemIdAndCaseId(1, 1)) {
            System.out.println("delete success");
        } else {
            System.out.println("delete fault");
        }
    }
}
