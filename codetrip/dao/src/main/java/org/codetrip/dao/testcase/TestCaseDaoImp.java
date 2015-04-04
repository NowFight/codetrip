package org.codetrip.dao.testcase;

import org.codetrip.common.so.TestCaseSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.testcase.TestCaseModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
@Repository
public class TestCaseDaoImp extends BaseDao<TestCaseModel> implements TestCaseDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<TestCaseModel> findBySO(TestCaseSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}
