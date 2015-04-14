package org.codetrip.facade.profile;

import org.codetrip.common.vo.TestCaseVO;
import org.codetrip.model.testcase.TestCaseModel;
import org.codetrip.service.testcase.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by RuFeng on 2015/4/14.
 */
@Controller
@RequestMapping(value = "profile")
public class AddTestCaseController {
    @Autowired
    private TestCaseService testCaseService;

    /**
     * 添加测试数据页面
     *
     * @param model
     * @param pid
     * @return String
     * */
    @RequestMapping(value = "/testcase/{PID}")
    public String addTestCasePage(Model model, @PathVariable(value = "PID")Long pid) {
        List<TestCaseVO> vos = testCaseService.listAllTestCases(pid);
        model.addAttribute("testcases", vos);
        model.addAttribute("pid", pid);
        return "profile/addtestcases";
    }

    /**
     * 添加测试数据
     *
     * @param request
     * @param pid
     * @return String
     * */
    @RequestMapping(value = "/testcase/{PID}/add", method = RequestMethod.POST)
    public String addTestCaseAction(HttpServletRequest request, @PathVariable(value = "PID")Long pid) {

        String testcase = request.getParameter("testcase");
        String stdoutput = request.getParameter("stdoutput");

        if (testcase != null && !testcase.equals("") &&
                stdoutput != null && !stdoutput.equals("")) {
            TestCaseModel testCase = new TestCaseModel();
            testCase.setTestData(testcase);
            testCase.setStandardOutput(stdoutput);
            testCase.setProblemId(pid);

            testCaseService.addTestCase(testCase);
        }
        return "redirect:/profile/testcase/" + pid;
    }
}
