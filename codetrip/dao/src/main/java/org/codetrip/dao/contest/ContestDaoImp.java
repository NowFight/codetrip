package org.codetrip.dao.contest;

import org.codetrip.common.so.ContestSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.contest.ContestModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
@Repository
public class ContestDaoImp extends BaseDao<ContestModel> implements ContestDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<ContestModel> findBySO(ContestSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}