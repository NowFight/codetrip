package org.codetrip.facade.profile;

import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RuFeng on 2015/2/13.
 */
@Controller("ProfileController")
@RequestMapping(value = "profile")
public class ProfileController {

    @Autowired
    private ProblemService problemService;

    /**
     * profile 导航
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "/sidebar/{selectItem}")
    public String profile(HttpServletRequest request, Model model,
                          @PathVariable(value = "selectItem") String selectItem) {
        return "redirect:/profile/" + selectItem;
    }

    /**
     * overview界面
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "overview")
    public String overview(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());
        model.addAttribute("sidebarItem", "overview");
        return "profile/profile";
    }

    /**
     * 我的比赛界面
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "mycontest")
    public String myContest(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());
        model.addAttribute("sidebarItem", "mycontest");
        return "profile/profile";
    }

    /**
     * 我的题目界面
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "myproblem")
    public String myProblem(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());
        model.addAttribute("sidebarItem", "myproblem");

        List<ProblemModel> problems = problemService.queryProblemsByUserId(((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getUserId());

        if (problems != null) {
            Collections.sort(problems, new Comparator<ProblemModel>() {
                @Override
                public int compare(ProblemModel o1, ProblemModel o2) {
                    return (o1.getProblemId() < o2.getProblemId() ? 1 :
                            (o1.getProblemId() == o2.getProblemId() ? 0 : -1));
                }
            });
        }
        model.addAttribute("problems", problems);
        return "profile/profile";
    }
}
