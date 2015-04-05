package org.codetrip.dao.statistic;

import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/20.
 */
@Repository("ProblemStatisticDao")
public class ProblemStatisticDaoImp extends BaseDao<ProblemStatisticModel>
        implements ProblemStatisticDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<ProblemStatisticModel> findBySO(ProblemStatisticSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}
