package org.codetrip.dao.participant;

import org.codetrip.common.so.ParticipantSO;
import org.codetrip.dao.Dao;
import org.codetrip.model.participant.ParticipantModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
public interface ParticipantDao extends Dao<ParticipantModel> {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     * */
    public List<ParticipantModel> findBySO(ParticipantSO so);
}
