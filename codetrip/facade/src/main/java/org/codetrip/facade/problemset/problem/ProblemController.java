package org.codetrip.facade.problemset.problem;

import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.statistic.ProblemStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RuFeng on 2015/2/17.
 */
@Controller("ProblemController")
@RequestMapping("problemset")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private ProblemStatisticService statisticService;

    /**
     * 显示题目
     *
     * @param request
     * @param model
     * @param pid
     * @return String
     * */
    @RequestMapping(value = "problem/{pid}")
    public String viewProblem(HttpServletRequest request, Model model,
                              @PathVariable(value = "pid") int pid) {
        if (request.getSession().getAttribute("currentUser") != null) {
            model.addAttribute("hasLogined", true);
            model.addAttribute("nikename", ((UserModel) request
                    .getSession()
                    .getAttribute("currentUser"))
                    .getNikeName());
        }

        ProblemModel problem = problemService.queryProblemByProblemId(pid);
        ProblemStatisticModel statistic = statisticService.queryStatisticByProblemId(pid);

        model.addAttribute("problem", problem);
        model.addAttribute("statistic", statistic);
        return "problemset/problem";
    }
}
