package org.codetrip.facade.solution;

import org.codetrip.common.enumerate.Language;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.solution.SolutionService;
import org.codetrip.service.statistic.ProblemStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RuFeng on 2015/2/21.
 */
@Controller("CommitController")
@RequestMapping(value = "commit")
public class CommitController {
    @Autowired
    private ProblemService problemService;

    @Autowired
    private SolutionService solutionService;

    @Autowired
    private ProblemStatisticService statisticService;

    /**
     * 跳转到提交界面
     *
     * @param request
     * @param model
     * @param problemId
     * @return String
     * */
    @RequestMapping(value = "problem/{problemId}", method = RequestMethod.GET)
    public String commitPage(HttpServletRequest request, Model model,
                             @PathVariable(value = "problemId") int problemId) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());
        ProblemModel problem = problemService.queryProblemByProblemId(problemId);
        if (problem != null) {
            model.addAttribute("title", problem.getTitle());
            model.addAttribute("problemId", problem.getProblemId());
            return "solution/commit";
        } else {
            return "problemset/problemset";
        }
    }

    /**
     * 提交代码
     * @param request
     * @param model
     * @param problemId
     * @return String
     * */
    @RequestMapping(value = "problem/{problemId}", method = RequestMethod.POST)
    public String commitCode(HttpServletRequest request, Model model,
                             @PathVariable(value = "problemId") int problemId) {
        SolutionModel solution = new SolutionModel();
        solution.setProblemId(problemId);
        Map<String, Language> map = new HashMap();
        map.put("GCC", Language.C);
        map.put("G++", Language.CPP);
        map.put("Java", Language.JAVA);
        solution.setLanguage(map.get(request.getParameter("language")));
        solution.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        solution.setUserId(((UserModel) request.getSession().getAttribute("currentUser")).getUserId());
        solution.setCodeContext(request.getParameter("codecontext"));
        if (solutionService.insertSolution(solution)) {
            ProblemStatisticModel statistic = statisticService.queryStatisticByProblemId(problemId);
            statistic.setSubmissions(statistic.getSubmissions() + 1);
            statisticService.updateStatisticByProblemId(problemId, statistic);
        }
        return "redirect:/status/personal";
    }
}
