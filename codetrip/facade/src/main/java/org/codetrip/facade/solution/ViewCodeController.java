package org.codetrip.facade.solution;

import org.codetrip.model.user.UserModel;
import org.codetrip.service.solution.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by RuFeng on 2015/3/7.
 */
@Controller
@RequestMapping(value = "viewcode")
public class ViewCodeController {
    @Autowired
    private SolutionService solutionService;


    @RequestMapping(value = "{SID}")
    public String viewCode(HttpServletRequest request, Model model,
                           @PathVariable(value = "SID") int solutionId) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());
        String codeContext = solutionService.querySolutionBySolutionId(solutionId).getCodeContext();
        model.addAttribute("code_context", codeContext);
        return "solution/viewcode";
    }
}
