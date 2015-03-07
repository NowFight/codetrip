package org.codetrip.facade.problemset;

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
@Controller("ProblemSetController")
@RequestMapping(value = "problemset")
public class ProblemSetController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private ProblemStatisticService statisticService;

    /**
     * 列出题目
     *
     * @param request
     * @param model
     * @param page
     * */
    @RequestMapping(value = "view/{page}")
    public String viewProblems(HttpServletRequest request, Model model,
                               @PathVariable(value = "page") int page) {
        if (request.getSession().getAttribute("currentUser") != null) {
            model.addAttribute("hasLogined", true);
            model.addAttribute("nikename", ((UserModel) request
                    .getSession()
                    .getAttribute("currentUser"))
                    .getNikeName());
        }

        List<ProblemModel> problems = problemService.listAllPublicProblem();
        if (problems != null) {
            Collections.sort(problems, new Comparator<ProblemModel>() {
                @Override
                public int compare(ProblemModel o1, ProblemModel o2) {
                    return (o1.getProblemId() > o2.getProblemId() ? 1 :
                            (o1.getProblemId() < o2.getProblemId() ? -1 : 0));
                }
            });

            int pageDiv = 3;
            List<ProblemModel> list = new ArrayList<ProblemModel>();
            for (int i = page * pageDiv; i < (page + 1) * pageDiv; i++) {
                if (i >= problems.size()) {
                    break;
                }
                list.add(problems.get(i));
            }

            Map<Integer, ProblemStatisticModel> statistics = new HashMap<Integer, ProblemStatisticModel>();
            for (ProblemModel problem : problems) {
                statistics.put(problem.getProblemId(), statisticService.queryStatisticByProblemId(problem.getProblemId()));
            }

            model.addAttribute("problems", list);
            model.addAttribute("pagediv", pageDiv);
            model.addAttribute("currentPage", page);
            model.addAttribute("pages", problems.size() / (pageDiv + 1));
            model.addAttribute("statistics", statistics);
        }
        return "problemset/problemset";
    }
}
