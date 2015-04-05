package org.codetrip.dao.rank;

import org.codetrip.common.so.RankSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.rank.RankModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository("RankDao")
public class RankDaoImp extends BaseDao<RankModel> implements RankDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<RankModel> findBySO(RankSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}
