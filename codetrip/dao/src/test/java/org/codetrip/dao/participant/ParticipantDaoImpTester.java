package org.codetrip.dao.participant;

import org.codetrip.model.participant.ParticipantModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public class ParticipantDaoImpTester {

    private ParticipantDao participantDao;

    @Before
    public void init() {
        BeanFactory factory = new ClassPathXmlApplicationContext(
                "SpringContext-core.xml",
                "SpringContext-mybatis.xml"
        );

        participantDao = (ParticipantDao) factory.getBean("ParticipantDao");
    }

    @Test
    public void testInsertNew() {
        ParticipantModel participiant = new ParticipantModel();
        participiant.setContestId(1);
        participiant.setTeamName("Team One");
        participiant.setRegisterDate(
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis())
        );
        participiant.setPassword("123456");

        if (participantDao.insertNew(participiant)) {
            System.out.println("insert ok");
        }
    }

    @Test
    public void testQueryByTeamId() {
        ParticipantModel participant = participantDao.queryByTeamId(1);
        if (participant != null) {
            System.out.println(participant.getTeamName() + " : " + participant.getRegisterDate());
        }
    }

    @Test
    public void testQueryByContestId() {
        List<ParticipantModel> participants = participantDao.queryByContestId(1);
        if (participants != null) {
            System.out.println(participants.size());
        }
    }

    @Test
    public void testUpdateByTeamId() {
        ParticipantModel participant = new ParticipantModel();
        participant.setPassword("654321");
        participant.setTeamName("TeamTwo");
        if (participantDao.updateByTeamId(1, participant)) {
            System.out.println("update ok");
        }
    }
}
