package org.codetrip.dao.contestproblem;

import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository
public class ContestProblemDaoImp extends BaseDao<ContestProblemModel> implements ContestProblemDao {
    private final static Logger LOG = Logger.getLogger(ContestProblemDao.class.getName());
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<ContestProblemModel> findBySO(ContestProblemSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }

    /**
     * 条件删除
     *
     * @param so
     */
    @Override
    public void deleteBySO(ContestProblemSO so) {
        int row = getSession().delete(getNamespace() + ".deleteBySO", so);
        if (row == 0) {
            LOG.warning("no row deleted!");
        }
    }

    /**
     * 统计记录数
     *
     * @param contestId
     * @return Integer
     */
    @Override
    public Integer count(Long contestId) {
        return getSession().selectOne(getNamespace() + ".count", contestId);
    }
}
