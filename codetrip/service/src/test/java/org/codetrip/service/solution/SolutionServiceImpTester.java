package org.codetrip.service.solution;

import org.codetrip.common.enumerate.Language;
import org.codetrip.model.solution.SolutionModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * Created by RuFeng on 2015/2/21.
 */
public class SolutionServiceImpTester {

    private SolutionService solutionService;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );
        solutionService = (SolutionService) beanFactory.getBean("SolutionService");
    }

    //@Test
    public void testInsertSolution() {
        SolutionModel solution = new SolutionModel();
        solution.setCodeContext("#include<stdio.h>");
        solution.setLanguage(Language.C);
        solution.setUserId(1);
        solution.setProblemId(1);
        solution.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
                .format(System.currentTimeMillis()));

        if (solutionService.insertSolution(solution)) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

    //@Test
    public void updateSolutionBySolutionId() {
        SolutionModel solution = new SolutionModel();
        if (solutionService.updateSolutionBySolutionId(1, solution)) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
        solution.setLanguage(Language.CPP);
        if (solutionService.updateSolutionBySolutionId(1, solution)) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testQuerySolutionBySolutionId() {
        SolutionModel solution =solutionService.querySolutionBySolutionId(1);
        if (solution != null) {
            System.out.println(solution.getLanguage());
        } else {
            System.out.println("查询失败");
        }
    }
}
