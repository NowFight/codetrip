package org.codetrip.dao.membership;

import org.codetrip.model.membership.MembershipModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public class MemberShipDaoImpTester {
    private MemberShipDao memberShipDao;

    @Before
    public void init() {
        BeanFactory factory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        memberShipDao = (MemberShipDao) factory.getBean("MemberShipDao");
    }

    @Test
    public void testInsertNew() {
        MembershipModel member = new MembershipModel();
        member.setTeamId(1);
        member.setUserId(1);
        if (memberShipDao.insertNew(member)) {
            System.out.println("insert ok");
        }
    }

    @Test
    public void testDeleteByMember() {
        MembershipModel member = new MembershipModel();
        member.setTeamId(1);
        member.setUserId(1);

        if (memberShipDao.deleteByMember(member)) {
            System.out.println("delete ok");
        }
    }

    @Test
    public void testQueryByTeamId() {
        List<MembershipModel> members = memberShipDao.queryByTeamId(1);
        if (members != null) {
            System.out.println(members.size());
        }
    }
}
