package org.codetrip.dao.statistic;

import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.statistic.ProblemStatisticModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/20.
 */
public interface ProblemStatisticDao extends Dao<ProblemStatisticModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<ProblemStatisticModel> findBySO(ProblemStatisticSO so);
}
