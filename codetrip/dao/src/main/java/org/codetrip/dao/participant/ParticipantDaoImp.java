package org.codetrip.dao.participant;

import org.codetrip.common.so.ParticipantSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.participant.ParticipantModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository
public class ParticipantDaoImp extends BaseDao<ParticipantModel> implements ParticipantDao {
    /**
     * 条件查询
     *
     * @param so
     * @return List
     */
    @Override
    public List<ParticipantModel> findBySO(ParticipantSO so) {
        return getSession().selectList(getNamespace() + ".findBySO", so);
    }
}
