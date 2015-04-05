package org.codetrip.dao.participant;

import org.codetrip.common.so.ParticipantSO;
import org.codetrip.model.participant.ParticipantModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

/**
 * Created by RuFeng on 2015/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext-core.xml", "classpath:SpringContext-mybatis.xml"})
public class ParticipantDaoImpTester {

    @Autowired
    private ParticipantDao participantDao;

    @Test
    @Rollback(value = true)
    public void test() {
        ParticipantModel participant = new ParticipantModel();
        participant.setTeamName("balabala");
        participant.setPassword("balabala");
        participant.setContestId(1L);
        participant.setRegisteDate(new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(System.currentTimeMillis()));
        participantDao.insert(participant);
        participantDao.find(participant.getId());
        ParticipantSO so = new ParticipantSO();
        so.setContestId(2L);
        participantDao.findBySO(so);
        participantDao.update(participant);
    }
}
