package org.codetrip.dao.problem;

import org.codetrip.common.so.ProblemSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.problem.ProblemModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/12.
 */
@Repository("ProblemDao")
public class ProblemDaoImp extends BaseDao<ProblemModel> implements ProblemDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<ProblemModel> findBySO(ProblemSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}
