package org.codetrip.dao.rank;

import org.codetrip.common.so.RankSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.rank.RankModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface RankDao extends Dao<RankModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<RankModel> findBySO(RankSO so);
}
