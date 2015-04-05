package org.codetrip.dao.solution;

import org.codetrip.common.so.SolutionSO;
import org.codetrip.dao.BaseDao;
import org.codetrip.model.solution.SolutionModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/21.
 */
@Repository("SolutionDao")
public class SolutionDaoImp extends BaseDao<SolutionModel>
        implements SolutionDao {
        /**
         * 条件查询
         *
         * @param so
         * @return List
         */
        @Override
        public List<SolutionModel> findBySO(SolutionSO so) {
                return getSession().selectList(getNamespace() + ".findBySO", so);
        }
}
