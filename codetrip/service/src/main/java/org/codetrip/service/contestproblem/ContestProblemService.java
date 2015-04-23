package org.codetrip.service.contestproblem;

import org.codetrip.common.vo.ProblemVO;
import org.codetrip.model.problem.ProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/4/22.
 */
public interface ContestProblemService {
    /**
     * 批量添加比赛题目
     *
     * @param problemIds
     * @param contestId
     * */
    public void batchAddProblem(Long contestId, List<Long> problemIds);

    /**
     * 列出比赛中包含的题目
     *
     * @param contestId
     * @return List
     * */
    public List<ProblemVO> listContestProblems(Long contestId);
}
