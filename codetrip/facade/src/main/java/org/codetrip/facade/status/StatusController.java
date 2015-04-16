package org.codetrip.facade.status;

import org.codetrip.common.vo.SolutionVO;
import org.codetrip.common.vo.UserVO;
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
@Controller
@RequestMapping(value = "status")
public class StatusController {
    @Autowired
    private SolutionService solutionService;

    /**
     * 展现所有的提交记录
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping
    public String showAllStatus(HttpServletRequest request, Model model) {
        UserVO userVO = (UserVO)request.getSession().getAttribute("currentUser");
        List<SolutionVO> solutionVOs = solutionService.listAllSolutions();
        if (userVO != null) {
            for (SolutionVO vo : solutionVOs) {
                if (vo.getUserId() == userVO.getId()) {
                    vo.setAccessable(Boolean.TRUE);
                }
            }
        }
        model.addAttribute("solutions", solutionVOs);
        return "status/status";
    }
}
