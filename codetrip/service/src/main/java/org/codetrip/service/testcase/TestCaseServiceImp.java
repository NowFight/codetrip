package org.codetrip.service.testcase;

import org.codetrip.dao.testcase.TestCaseDao;
import org.codetrip.model.testcase.TestCaseModel;
import org.codetrip.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
@Service("TestCaseService")
public class TestCaseServiceImp extends BaseService implements TestCaseService {

    @Autowired
    TestCaseDao testCaseDao;
    /**
     * 添加测试数据
     *
     * @param testcase
     * @return boolean
     * @paran testcase
     */
    @Override
    public boolean insertTestCase(TestCaseModel testcase) {
        return testCaseDao.insertTestCase(testcase);
    }

    /**
     * 通过测试数据ID和题目ID更新测试数据
     *
     * @param problemId
     * @param caseId
     * @param testcase
     * @return boolean
     */
    @Override
    public boolean updateTestCaseByProblemIdAndCaseId(int problemId, int caseId, TestCaseModel testcase) {
        return testCaseDao.updateTestCaseByProblemIdAndCaseId(problemId, caseId, testcase);
    }

    /**
     * 通过题目ID查询测试数据
     *
     * @param problemId
     * @return List
     */
    @Override
    public List<TestCaseModel> queryTestCaseByProblemId(int problemId) {
        return testCaseDao.queryTestCaseByProblemId(problemId);
    }

    /**
     * 通过测试数据ID和题目ID删除测试数据
     *
     * @param problemId
     * @param caseId
     * @return boolean
     */
    @Override
    public boolean deleteTestCaseByProblemIdAndCaseId(int problemId, int caseId) {
        return testCaseDao.deleteTestCaseByProblemIdAndCaseId(problemId, caseId);
    }
}
