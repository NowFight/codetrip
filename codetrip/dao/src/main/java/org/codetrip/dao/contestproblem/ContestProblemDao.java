package org.codetrip.dao.contestproblem;

import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.contestproblem.ContestProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface ContestProblemDao extends Dao<ContestProblemModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<ContestProblemModel> findBySO(ContestProblemSO so);

    /**
     * 条件删除
     *
     * @param so
     * */
    public void deleteBySO(ContestProblemSO so);
}
