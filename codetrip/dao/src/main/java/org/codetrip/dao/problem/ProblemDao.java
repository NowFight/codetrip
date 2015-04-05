package org.codetrip.dao.problem;

import org.codetrip.common.so.ProblemSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.problem.ProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/12.
 */
public interface ProblemDao extends Dao<ProblemModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<ProblemModel> findBySO(ProblemSO so);
}
