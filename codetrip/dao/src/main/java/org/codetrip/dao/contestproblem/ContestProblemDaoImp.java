package org.codetrip.dao.contestproblem;

import org.codetrip.dao.BaseDao;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuFeng on 2015/3/21.
 */
@Repository("ContestProblemDao")
public class ContestProblemDaoImp extends BaseDao implements ContestProblemDao {
    /**
     * 添加比赛题目
     *
     * @param problems
     * @return boolean
     */
    @Override
    public boolean insertNew(ContestProblemModel problems) {
        if (getSession().insert(getNamespace() + ".insertNew", problems) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过题目ID和比赛ID删除比赛题目
     *
     * @param contestId
     * @param problemId
     * @return boolean
     */
    @Override
    public boolean deleteByContestIdAndProblemId(int contestId, int problemId) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("contestId", contestId);
        map.put("problemId", problemId);
        if (getSession().delete(getNamespace() + ".deleteByContestIdAndProblemId", map) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 通过比赛ID查找题目
     *
     * @param contestId
     * @return List
     */
    @Override
    public List<ContestProblemModel> queryByContestId(int contestId) {
        List<ContestProblemModel> contestProblems =
                getSession().selectList(getNamespace() + ".queryByContestId", contestId);
        if (contestProblems.isEmpty()) {
            return null;
        }
        return contestProblems;
    }

    /**
     * 通过题目ID查找关联的比赛
     *
     * @param problemId
     * @return List
     */
    @Override
    public List<ContestProblemModel> queryByProblemId(int problemId) {
        List<ContestProblemModel> contestProblems =
                getSession().selectList(getNamespace() + ".queryByProblemId", problemId);
        if (contestProblems.isEmpty()) {
            return null;
        }
        return contestProblems;
    }
}
