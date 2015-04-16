package org.codetrip.facade.profile;

import org.codetrip.common.vo.UserVO;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.testcase.TestCaseModel;
import org.codetrip.model.user.UserModel;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.testcase.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by RuFeng on 2015/2/14.
 */
@Controller
@RequestMapping(value = "profile")
public class AddProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 添加题目页面
     *
     * @return String
     * */
    @RequestMapping(value = "/addproblem")
    public String addProblemPage() {
        return "profile/addproblem";
    }

    /**
     * 添加题目描述
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "/addproblem/description")
    public String addProblemAction(HttpServletRequest request, HttpServletResponse response, Model model) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String inputdesc = request.getParameter("inputdesc");
        String outputdesc = request.getParameter("outputdesc");
        String inputexp = request.getParameter("inputexp");
        String outputexp = request.getParameter("outputexp");
        String timelimit = request.getParameter("timelimit");
        String memlimit = request.getParameter("memlimit");
        String spj = request.getParameter("spj");

        ProblemModel problem = new ProblemModel();
        UserVO userVO = (UserVO)request.getSession().getAttribute("currentUser");
        if (userVO != null) {
            problem.setUserId(userVO.getId());
            problem.setTimeLimit(Integer.parseInt(timelimit));
            problem.setMemoryLimit(Integer.parseInt(memlimit));
            problem.setTitle(title);
            problem.setDescription(description);
            problem.setInputDescription(inputdesc);
            problem.setOutputDescription(outputdesc);
            problem.setSampleInput(inputexp);
            problem.setSampleOutput(outputexp);
            problem.setVisible(Boolean.TRUE);
            problem.setContestId(0L);
            problem.setSpecialJudge(spj.equals("YES") ? Boolean.TRUE : Boolean.FALSE);

            problemService.addProblem(problem);
        }
        return "redirect:/profile/problems";
    }
}
