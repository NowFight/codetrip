package org.codetrip.facade.profile;

import org.codetrip.common.vo.ProblemVO;
import org.codetrip.common.vo.UserVO;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by RuFeng on 2015/4/13.
 */
@Controller
@RequestMapping(value = "profile")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 题目页面
     *
     * @return String
     * */
    @RequestMapping(value = "/myproblems")
    public String problemPage(HttpServletRequest request, Model model) {
        UserVO user = (UserVO)request.getSession().getAttribute("currentUser");
        if (user != null) {
            List<ProblemVO> voList = problemService.getCurrentUsersAllProblems(user.getId());
            model.addAttribute("problems", voList);
        }
        return "profile/myproblems";
    }
}
