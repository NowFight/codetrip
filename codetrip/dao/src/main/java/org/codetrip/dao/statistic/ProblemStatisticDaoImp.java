package org.codetrip.dao.statistic;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.springframework.stereotype.Repository;

/**
 * Created by RuFeng on 2015/2/20.
 */
@Repository("ProblemStatisticDao")
public class ProblemStatisticDaoImp extends BaseDao implements ProblemStatisticDao {
    /**
     * 插入统计信息
     *
     * @param statistic
     * @return boolean
     */
    @Override
    public boolean insertStatistic(ProblemStatisticModel statistic) {
        if (getSession().insert(getNamespace() + ".insertStatistic", statistic) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过题目ID更新统计信息
     *
     * @param problemId
     * @param statistic
     * @return boolean
     */
    @Override
    public boolean updateStatisticByProblemId(int problemId, ProblemStatisticModel statistic) {
        statistic.setProblemId(problemId);
        if (getSession().update(getNamespace() + ".updateStatisticByProblemId", statistic) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过题目ID查询统计信息
     *
     * @param problemId
     * @return ProblemStatisticModel
     */
    @Override
    public ProblemStatisticModel queryStatisticByProblemId(int problemId) {
        return getSession().selectOne(getNamespace() + ".queryStatisticByProblemId", problemId);
    }

    /**
     * 通过题目ID删除统计信息
     *
     * @param problemId
     * @return boolean
     */
    @Override
    public boolean deleteStatisticByProblemId(int problemId) {
        if (getSession().delete(getNamespace() + ".deleteStatisticByProblemId", problemId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
