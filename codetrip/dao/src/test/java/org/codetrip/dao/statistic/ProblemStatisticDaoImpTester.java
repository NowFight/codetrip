package org.codetrip.dao.statistic;

import org.codetrip.model.statistic.ProblemStatisticModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by RuFeng on 2015/2/20.
 */
public class ProblemStatisticDaoImpTester {

    private ProblemStatisticDao problemStatistic;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        problemStatistic = (ProblemStatisticDao) beanFactory.getBean("ProblemStatisticDao");
    }

    @Test
    public void testInsertStatistic() {
        ProblemStatisticModel statistic = new ProblemStatisticModel();
        statistic.setProblemId(1);
        statistic.setCompileError(0);
        statistic.setSubmissions(0);
        statistic.setMemLimitError(0);
        statistic.setOutputLimitError(0);
        statistic.setRuntimeError(0);
        statistic.setTimeLimitError(0);
        statistic.setPresentationError(0);
        statistic.setWrongAnswer(0);

        if (problemStatistic.insertStatistic(statistic)) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testUpdateStatisticByProblemId() {
        ProblemStatisticModel statistic = new ProblemStatisticModel();
        if (problemStatistic.updateStatisticByProblemId(1, statistic)) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }

        statistic.setWrongAnswer(1);
        if (problemStatistic.updateStatisticByProblemId(1, statistic)) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testQueryStatisticByProblemId() {
        ProblemStatisticModel statistic = problemStatistic.queryStatisticByProblemId(1);
        if (statistic != null) {
            System.out.println("查询成功");
        } else {
            System.out.println("查询失败");
        }
    }

    @Test
    public void testDeleteStatisticByProblemId() {
        if (problemStatistic.deleteStatisticByProblemId(1)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
