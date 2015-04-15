package org.codetrip.facade.problemset;

import org.codetrip.common.vo.ProblemVO;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.statistic.ProblemStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by RuFeng on 2015/2/13.
 */
@Controller
@RequestMapping(value = "problemset")
public class ProblemSetController {

    @Autowired
    private ProblemService problemService;

    /**
     * 列出题目
     *
     * @param model
     * */
    @RequestMapping(value = "/")
    public String listProblems(Model model) {
        List<ProblemVO> problemVOs = problemService.listAllProblems();
        model.addAttribute("problems", problemVOs);
        return "problemset/problemset";
    }

    /**
     * 浏览题目
     *
     * @param model
     * */
    @RequestMapping(value = "/view/{pid}")
    public String viewProblem(Model model, @PathVariable(value = "pid")Long pid) {
        ProblemVO problemVO = problemService.viewProblem(pid);

        if (problemVO != null) {
            model.addAttribute("problem", problemVO);
            return "problemset/problem";
        }
        return "problemset/problemset";
    }
}
