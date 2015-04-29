package org.codetrip.service.contestproblem;

import org.codetrip.common.vo.ContestProblemVO;
import org.codetrip.common.vo.ContestVO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.model.problem.ProblemModel;
import org.springframework.beans.factory.parsing.Problem;

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

    /**
     * 取得比赛中的题目
     *
     * @param contestProblemId
     * @return ProblemVO
     * */
    public ProblemVO getProblem(Long contestProblemId);

    /**
     * 获得比赛信息
     *
     * @param contestProblemId
     * @return ContestVO
     * */
    public ContestVO getContest(Long contestProblemId);

    /**
     * 获得比赛题目的关系
     *
     * @param contestProblemId
     * @return ContestProblemVO
     * */
    public ContestProblemVO getContestProblem(Long contestProblemId);
}
