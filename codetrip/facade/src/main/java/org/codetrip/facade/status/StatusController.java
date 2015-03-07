package org.codetrip.facade.status;

import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.solution.SolutionService;
import org.codetrip.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by RuFeng on 2015/2/22.
 */
@Controller("StatusController")
@RequestMapping(value = "status")
public class StatusController {
    @Autowired
    private SolutionService solutionService;

    @Autowired
    private ProblemService problemService;

    @Autowired
    private UserService userService;

    /**
     * 用户个人status
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "personal")
    public String personalStatus(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        UserModel user = (UserModel) request.getSession().getAttribute("currentUser");
        model.addAttribute("nikename", user.getNikeName());

        List<SolutionModel> solutions = solutionService.querySolutionByUserId(user.getUserId());

        if (solutions != null) {
            Collections.sort(solutions, new Comparator<SolutionModel>() {
                @Override
                public int compare(SolutionModel o1, SolutionModel o2) {
                    return (o1.getSolutionId() < o2.getSolutionId() ? 1 :
                            (o1.getSolutionId() > o2.getSolutionId() ? -1 : 0));
                }
            });

            Map<Integer, ProblemModel> problems = new HashMap<Integer, ProblemModel>();
            for (SolutionModel solution : solutions) {
                problems.put(solution.getSolutionId(), problemService.queryProblemByProblemId(solution.getProblemId()));
            }
            model.addAttribute("solutions", solutions);
            model.addAttribute("problems", problems);
            model.addAttribute("nikename", user.getNikeName());
        }
        return "status/status";
    }

    /**
     * 全局status
     *
     * */
    @RequestMapping(value = "global")
    public String globalStatus(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("currentUser") != null) {
            model.addAttribute("hasLogined", true);
            model.addAttribute("nikename", ((UserModel) request
                    .getSession()
                    .getAttribute("currentUser"))
                    .getNikeName());
        }

        List<SolutionModel> solutions = solutionService.queryAllSolutions();

        if (solutions != null) {
            Collections.sort(solutions, new Comparator<SolutionModel>() {
                @Override
                public int compare(SolutionModel o1, SolutionModel o2) {
                    return (o1.getSolutionId() < o2.getSolutionId() ? 1 :
                            (o1.getSolutionId() > o2.getSolutionId() ? -1 : 0));
                }
            });
            Map<Integer, String> nikenames = new HashMap<Integer, String>();
            Map<Integer, ProblemModel> problems = new HashMap<Integer, ProblemModel>();
            for (SolutionModel solution : solutions) {
                nikenames.put(solution.getSolutionId(),
                        userService.queryUserByUserId(solution.getUserId()).getNikeName());
                problems.put(solution.getSolutionId(),
                        problemService.queryProblemByProblemId(solution.getProblemId()));
            }
            model.addAttribute("solutions", solutions);
            model.addAttribute("problems", problems);
            model.addAttribute("nikenames", nikenames);
            model.addAttribute("nav_active_item", "Status");
            model.addAttribute("global", true);
        }
        return "status/status";
    }
}
