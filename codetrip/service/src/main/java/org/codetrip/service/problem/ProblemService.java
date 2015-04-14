package org.codetrip.service.problem;

import org.codetrip.common.vo.ProblemVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.problem.ProblemModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/13.
 */
public interface ProblemService {
    /**
     * 添加题目
     *
     * @param problem
     * */
    public void addProblem(ProblemModel problem);

    /**
     * 获得用户拥有的所有题目
     *
     * @param userId
     * @return List
     * */
    public List<ProblemVO> getCurrentUsersAllProblems(Long userId);
}
