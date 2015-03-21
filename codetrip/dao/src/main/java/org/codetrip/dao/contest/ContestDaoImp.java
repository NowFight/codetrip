package org.codetrip.dao.contest;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.contest.ContestModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by RuFeng on 2015/3/14.
 */
@Repository("ContestDao")
public class ContestDaoImp extends BaseDao implements ContestDao {
    /**
     * 添加比赛
     *
     * @param contest
     * @return boolean
     */
    @Override
    public boolean insertContest(ContestModel contest) {
        if (getSession().insert(getMapperPrefix() + ".insertContest", contest) == 1)
            return true;
        return false;
    }

    /**
     * 通过比赛ID查询比赛
     *
     * @param contestId
     * @return ContestModel
     */
    @Override
    public ContestModel queryContestByContestId(Integer contestId) {
        return getSession().selectOne(getMapperPrefix() + ".queryContestByContestId", contestId);
    }

    /**
     * 列出所有比赛
     *
     * @return List
     */
    @Override
    public List<ContestModel> queryAllContests() {
        List<ContestModel> contests = getSession().selectList(getMapperPrefix() + ".queryAllContests");
        if (contests.size() == 0) {
            return null;
        } else {
            return contests;
        }
    }

    /**
     * 通过比赛ID更新比赛
     *
     * @param contestId
     * @param contest
     * @return boolean
     */
    @Override
    public boolean updateContestByContestId(Integer contestId, ContestModel contest) {
        contest.setContestId(contestId);
        if (getSession().update(getMapperPrefix() + ".updateContestByContestId", contest) == 1)
            return true;
        return false;
    }
}