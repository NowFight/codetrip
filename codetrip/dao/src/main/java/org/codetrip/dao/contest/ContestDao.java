package org.codetrip.dao.contest;

import org.codetrip.common.so.ContestSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.contest.ContestModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
public interface ContestDao extends Dao<ContestModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<ContestModel> findBySO(ContestSO so);
}
