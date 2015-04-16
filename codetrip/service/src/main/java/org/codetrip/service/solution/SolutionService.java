package org.codetrip.service.solution;

import org.codetrip.common.vo.SolutionVO;
import org.codetrip.model.solution.SolutionModel;

import java.util.List;

/**
 * Created by RuFeng on 2015/2/21.
 */
public interface SolutionService {

    /**
     * 提交代码, 并更新题目的提交次数
     *
     * @param solution
     * */
    public void commit(SolutionModel solution);

    /**
     * 列出所有的solution记录
     *
     * @return List
     * */
    public List<SolutionVO> listAllSolutions();

    /**
     * 获取单个solution记录
     *
     * @param id
     * @return String
     * */
    public SolutionVO getCodeContent(Long id);
}
