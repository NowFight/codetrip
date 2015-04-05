package org.codetrip.dao.solution;

import org.codetrip.common.so.SolutionSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.solution.SolutionModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/20.
 */
public interface SolutionDao extends Dao<SolutionModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<SolutionModel> findBySO(SolutionSO so);
}
