package org.codetrip.dao.statistic;

import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class ProblemStatisticDaoImpTester {

    @Autowired
    private ProblemStatisticDao problemStatisticDao;

    @Test
    @Rollback(value = true)
    public void test() {
        ProblemStatisticSO so = new ProblemStatisticSO();
        so.setProblemId(1L);
        List<ProblemStatisticModel> statisticModelList = problemStatisticDao.findBySO(so);
        System.out.println(statisticModelList.isEmpty());
    }
}
