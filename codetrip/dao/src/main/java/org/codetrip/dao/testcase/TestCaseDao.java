package org.codetrip.dao.testcase;

import org.codetrip.model.testcase.TestCaseModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
public interface TestCaseDao {

    /**
     * 添加测试数据
     *
     * @return boolean
     * @paran testcase
     */
    public boolean insertTestCase(TestCaseModel testcase);

    /**
     * 通过测试数据ID和题目ID更新测试数据
     *
     * @param problemId
     * @param caseId
     * @param testcase
     * @return boolean
     */
    public boolean updateTestCaseByProblemIdAndCaseId(int problemId, int caseId, TestCaseModel testcase);

    /**
     * 通过题目ID查询测试数据
     *
     * @param problemId
     * @return List
     */
    public List<TestCaseModel> queryTestCaseByProblemId(int problemId);

    /**
     * 通过测试数据ID和题目ID删除测试数据
     *
     * @param problemId
     * @param caseId
     * @return boolean
     * */
    public boolean deleteTestCaseByProblemIdAndCaseId(int problemId, int caseId);
}
