package org.codetrip.dao.problem;

import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.model.problem.ProblemModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/12.
 */
public class ProblemDaoImpTester {

    private ProblemDao problemDao;

    @Before
    public void init() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        problemDao = (ProblemDao) beanFactory.getBean("ProblemDao");
    }

    @Test
    public void testInsertProblem() {
        ProblemModel problemModel = new ProblemModel();
        problemModel.setContestId(-1);
        problemModel.setTitle("Simple A + B");
        problemModel.setUserId(0);
        problemModel.setDescription("caculate A + B");
        problemModel.setInputDescription("Input A B");
        problemModel.setOutputDescription("Output C");
        problemModel.setSampleInput("1 2");
        problemModel.setSampleOutput("3");
        problemModel.setVisiable("YES");
        problemModel.setSpecialJudge("NO");
        problemModel.setTimeLimit(2000);
        problemModel.setMemoryLimit(65536);

        if (problemDao.insertProblem(problemModel)) {
            System.out.println("题目添加成功 : Problem ID : " + problemModel.getProblemId());
        } else {
            System.out.println("题目添加失败");
        }
    }

    //@Test
    public void testQueryProblemsByUserId() {
        List<ProblemModel> problems = problemDao.queryProblemsByUserId(0);
        if (problems != null) {
            for (ProblemModel problem : problems) {
                System.out.println("Problem Title = " + problem.getTitle());
            }
        }
    }

    //@Test
    public void testQueryProblemsByProblemId() {
        ProblemModel problem = problemDao.queryProblemByProblemId(1);
        if (problem != null) {
            System.out.println("Problem Title = " + problem.getTitle());
        }
    }

    //@Test
    public void testQueryProblemsByContestId() {
        List<ProblemModel> problems = problemDao.queryProblemsByContestId(-1);
        if (problems != null) {
            for (ProblemModel problem : problems) {
                System.out.println("Problem Title = " + problem.getTitle());
            }
        }
    }

    @Test
    public void testUpdateProblemByProblemId() {
        ProblemModel problemModel = new ProblemModel();
        //problemModel.setContestId(0);
        //problemModel.setTitle("Simple A + B");
        //problemModel.setUserId(0);
        //problemModel.setDescription("caculate A + B");
        //problemModel.setInputDescription("Input A B");
        problemModel.setOutputDescription("Output C");
        problemModel.setSampleInput("1 2");
        problemModel.setSampleOutput("3");
        problemModel.setVisiable("YES");
        problemModel.setSpecialJudge("NO");
        problemModel.setTimeLimit(1000);
        problemModel.setMemoryLimit(65536);
        if (problemDao.updateProblemByProblemId(1, problemModel)) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    //@Test
    public void testListAllPublicProblem() {
        List<ProblemModel> problems = problemDao.listAllPublicProblem();
        for (ProblemModel problem : problems) {
            System.out.println("problem title = " + problem.getTitle());
        }
    }
}
