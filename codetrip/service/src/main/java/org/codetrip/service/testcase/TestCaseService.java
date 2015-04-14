package org.codetrip.service.testcase;

import org.codetrip.common.vo.TestCaseVO;
import org.codetrip.model.testcase.TestCaseModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
public interface TestCaseService {

    /**
     * 添加测试数据
     *
     * @param testcase
     * */
    public void addTestCase(TestCaseModel testcase);

    /**
     * 列出当前题目的所有testcase
     *
     * @param problemId
     * @return List
     * */
    public List<TestCaseVO> listAllTestCases(Long problemId);
}
