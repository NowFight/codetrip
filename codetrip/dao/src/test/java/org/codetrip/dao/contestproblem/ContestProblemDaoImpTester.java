package org.codetrip.dao.contestproblem;

import org.codetrip.model.contestproblem.ContestProblemModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public class ContestProblemDaoImpTester {
    private ContestProblemDao contestProblemDao;

    @Before
    public void init() {
        BeanFactory factory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );
        contestProblemDao = (ContestProblemDao) factory.getBean("ContestProblemDao");
    }

    @Test
    public void testInsertNew() {
        ContestProblemModel contestProblemModel = new ContestProblemModel();
        contestProblemModel.setContestId(1);
        contestProblemModel.setProblemId(1);
        if (contestProblemDao.insertNew(contestProblemModel)) {
            System.out.println("insert new ok");
        }
    }

    @Test
    public void testQueryByContestId() {
        List<ContestProblemModel> contestProblemModels = contestProblemDao.queryByContestId(1);
        if (contestProblemModels != null) {
            for (ContestProblemModel contestProblemModel : contestProblemModels) {
                System.out.println(contestProblemModel.getContestId() + " : " + contestProblemModel.getProblemId());
            }
        }
    }

    @Test
    public void testQueryByProblemId() {
        List<ContestProblemModel> contestProblemModels = contestProblemDao.queryByProblemId(1);
        if (contestProblemModels != null) {
            for (ContestProblemModel contestProblemModel : contestProblemModels) {
                System.out.println(contestProblemModel.getContestId() + " : " + contestProblemModel.getProblemId());
            }
        }
    }

    @Test
    public void testDeleteByContestIdAndProblemId() {
        if (contestProblemDao.deleteByContestIdAndProblemId(1, 1)) {
            System.out.println("Delete ok");
        }
    }
}