package org.codetrip.service.problem;

import org.codetrip.model.problem.ProblemModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/13.
 */
public class ProblemServiceImpTester {
    private ProblemService problemService;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );
        problemService = (ProblemService) beanFactory.getBean("ProblemService");
    }

    @Test
    public void testInsertProblem() {
        ProblemModel problemModel = new ProblemModel();
        problemModel.setContestId(-1);
        problemModel.setTitle("Simple A + B II");
        problemModel.setUserId(0);
        problemModel.setDescription("caculate A + B");
        problemModel.setInputDescription("Input A B");
        problemModel.setOutputDescription("Output C");
        problemModel.setSampleInput("1 2");
        problemModel.setSampleOutput("3");
        problemModel.setVisiable("YES");
        problemModel.setSpecialJudge("NO");
        problemModel.setTimeLimit(1000);
        problemModel.setMemoryLimit(65536);

        if (problemService.insertProblem(problemModel)) {
            System.out.println("题目添加成功");
        } else {
            System.out.println("题目添加失败");
        }
    }

    @Test
    public void testQueryProblesByProblemId() {
        ProblemModel problem = problemService.queryProblemByProblemId(3);
        if (problem == null) {
            System.out.println("NO Problem with pid = 1");
        } else {
            System.out.println("Problem title = " + problem.getTitle());
        }
    }

    @Test
    public void testQueryProblemsByUserId() {
        List<ProblemModel> problems = problemService.queryProblemsByUserId(0);
        if (problems == null) {
            System.out.println("NO Problem");
        } else {
            for (ProblemModel problem : problems) {
                System.out.println("Problem title = " + problem.getTitle());
            }
        }
    }

    @Test
    public void testUpdateProblemByProblemId() {
        ProblemModel problem = new ProblemModel();
        problem.setMemoryLimit(65536);
        problem.setTimeLimit(2000);
        if (problemService.updateProblemByProblemId(4, problem)) {
            System.out.println("Update Success");
        } else {
            System.out.println("Update fault");
        }
    }

    @Test
    public void testListAllPublicProblem() {
        List<ProblemModel> problems = problemService.listAllPublicProblem();
        if (problems != null) {
            for (ProblemModel problem : problems) {
                System.out.println(problem.getTitle());
            }
        } else {
            System.out.println("No public problem");
        }
    }

    @Test
    public void testQueryLatestProblemIdByUserId() {
        System.out.println("Max Problem ID = " + problemService.queryLatestProblemIdByUserId(4));
    }
}
