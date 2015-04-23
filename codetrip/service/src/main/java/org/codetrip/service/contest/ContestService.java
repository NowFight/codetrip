package org.codetrip.service.contest;

import org.codetrip.common.vo.ContestVO;
import org.codetrip.model.contest.ContestModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
public interface ContestService {
    /**
     * 添加比赛
     *
     * @param contest
     * */
    public void addContest(ContestModel contest);

    /**
     * 列出用户的所有比赛
     *
     * @param userId
     * @return List
     * */
    public List<ContestVO> listUsersContests(Long userId);

    /**
     * 列出所有公共的比赛
     *
     * @return List
     * */
    public List<ContestVO> listAllPublicContests();
}
