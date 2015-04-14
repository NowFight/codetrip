package org.codetrip.service.testcase;

import org.codetrip.common.so.TestCaseSO;
import org.codetrip.common.vo.TestCaseVO;
import org.codetrip.dao.testcase.TestCaseDao;
import org.codetrip.model.testcase.TestCaseModel;
import org.codetrip.service.BaseService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/2/15.
 */
@Service("TestCaseService")
public class TestCaseServiceImp extends BaseService implements TestCaseService {

    private static final Logger LOG = Logger.getLogger(TestCaseService.class.getName());

    @Autowired
    TestCaseDao testCaseDao;

    @Autowired
    Mapper dozerMapper;

    /**
     * 添加测试数据
     *
     * @param testcase
     */
    @Override
    public void addTestCase(TestCaseModel testcase) {
        if (testcase == null) {
            LOG.warning("testcase is null when add testcase");
        }

        testCaseDao.insert(testcase);
    }

    /**
     * 列出当前题目的所有testcase
     *
     * @param problemId
     * @return List
     */
    @Override
    public List<TestCaseVO> listAllTestCases(Long problemId) {
        TestCaseSO so = new TestCaseSO();
        so.setProblemId(problemId);
        List<TestCaseModel> testcases = testCaseDao.findBySO(so);

        List<TestCaseVO> vos = new ArrayList<TestCaseVO>();
        if (!testcases.isEmpty()) {
            for (TestCaseModel testcase : testcases) {
                TestCaseVO vo = dozerMapper.map(testcase, TestCaseVO.class);
                vos.add(vo);
            }
        }
        return vos;
    }
}
