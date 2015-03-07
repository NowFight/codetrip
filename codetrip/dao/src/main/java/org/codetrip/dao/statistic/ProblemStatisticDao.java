package org.codetrip.dao.statistic;

import org.codetrip.model.statistic.ProblemStatisticModel;

/**
 * Created by RuFeng on 2015/2/20.
 */
public interface ProblemStatisticDao {

    /**
     * 插入统计信息
     *
     * @param statistic
     * @return boolean
     */
    public boolean insertStatistic(ProblemStatisticModel statistic);

    /**
     * 通过题目ID更新统计信息
     *
     * @param problemId
     * @param statistic
     * @return boolean
     * */
    public boolean updateStatisticByProblemId(int problemId, ProblemStatisticModel statistic);

    /**
     * 通过题目ID查询统计信息
     *
     * @param problemId
     * @return ProblemStatisticModel
     */
    public ProblemStatisticModel queryStatisticByProblemId(int problemId);

    /**
     *
     * 通过题目ID删除统计信息
     *
     * @param problemId
     * @return boolean
     * */
    public boolean deleteStatisticByProblemId(int problemId);
}
