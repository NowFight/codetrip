package org.codetrip.dao.membership;

import org.codetrip.common.so.MemberShipSO;
import org.codetrip.model.membership.MembershipModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by RuFeng on 2015/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class MemberShipDaoImpTester {
    @Autowired
    private MemberShipDao memberShipDao;

    @Test
    @Rollback(value = true)
    public void test() {
        MembershipModel member = new MembershipModel();
        member.setTeamId(1L);
        member.setUserId(1L);

        memberShipDao.insert(member);
        memberShipDao.find(member.getId());
        memberShipDao.update(member);
        memberShipDao.delete(member.getId());
        MemberShipSO so = new MemberShipSO();
        so.setUserId(1L);
        memberShipDao.deleteBySO(so);
    }
}
