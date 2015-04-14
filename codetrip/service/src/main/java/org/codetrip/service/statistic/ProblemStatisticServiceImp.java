package org.codetrip.service.statistic;

import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RuFeng on 2015/2/20.
 */
@Service("ProblemStatisticService")
public class ProblemStatisticServiceImp extends BaseService
        implements ProblemStatisticService {

    @Autowired
    private ProblemStatisticDao statisticDao;
}
