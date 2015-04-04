package org.codetrip.dao.testcase;

import org.codetrip.common.so.TestCaseSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.testcase.TestCaseModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
public interface TestCaseDao extends Dao<TestCaseModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<TestCaseModel> findBySO(TestCaseSO so);
}
