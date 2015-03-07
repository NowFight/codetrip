package org.codetrip.service.statistic;

import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RuFeng on 2015/2/20.
 */
@Service("ProblemStatisticService")
public class ProblemStatisticServiceImp extends BaseService
        implements ProblemStatisticService {

    @Autowired
    private ProblemStatisticDao statisticDao;

    /**
     * 插入统计信息
     *
     * @param statistic
     * @return boolean
     */
    @Override
    public boolean insertStatistic(ProblemStatisticModel statistic) {
        return statisticDao.insertStatistic(statistic);
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
        return statisticDao.updateStatisticByProblemId(problemId, statistic);
    }

    /**
     * 通过题目ID查询统计信息
     *
     * @param problemId
     * @return ProblemStatisticModel
     */
    @Override
    public ProblemStatisticModel queryStatisticByProblemId(int problemId) {
        return statisticDao.queryStatisticByProblemId(problemId);
    }

    /**
     * 通过题目ID删除统计信息
     *
     * @param problemId
     * @return boolean
     */
    @Override
    public boolean deleteStatisticByProblemId(int problemId) {
        return statisticDao.deleteStatisticByProblemId(problemId);
    }
}
