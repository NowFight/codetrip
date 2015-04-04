package org.codetrip.dao.testcase;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.testcase.TestCaseModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuFeng on 2015/2/15.
 */
@Repository("TestCaseDao")
public class TestCaseDaoImp extends BaseDao implements TestCaseDao {

    /**
     * 添加测试数据
     *
     * @param testcase
     * @return boolean
     * @paran testcase
     */
    @Override
    public boolean insertTestCase(TestCaseModel testcase) {
        if (getSession().insert(getNamespace() + ".insertTestCase", testcase) == 1) {
            return true;
        } else {
            return false;
        }
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
        testcase.setProblemId(problemId);
        testcase.setCaseNumber(caseId);
        if (getSession().update(getNamespace() + ".updateTestCaseByProblemIdAndCaseId", testcase) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过题目ID查询测试数据
     *
     * @param problemId
     * @return List
     */
    @Override
    public List<TestCaseModel> queryTestCaseByProblemId(int problemId) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("problemId", problemId);

        List<TestCaseModel> testcases = getSession().selectList(
                getNamespace() + ".queryTestCaseByProblemId",
                map
        );

        if (testcases.size() > 0) {
            return testcases;
        } else {
            return null;
        }
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
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("problemId", problemId);
        map.put("caseId", caseId);

        if (getSession().delete(getNamespace() + ".deleteTestCaseByProblemIdAndCaseId", map) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
