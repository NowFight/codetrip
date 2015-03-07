package org.codetrip.facade.profile.addproblem;

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

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by RuFeng on 2015/2/14.
 */
@Controller("AddProblemController")
@RequestMapping(value = "profile/addproblem")
public class AddProblemController {

    @Autowired
    private ProblemService problemService;


    @Autowired
    private TestCaseService testCaseService;

    /**
     * 题目界面导航
     *
     * @param request
     * @param model
     * @param selectItem
     * @return String
     * */
    @RequestMapping(value = "sidebar/{selectItem}", method = RequestMethod.GET)
    public String addProblem(HttpServletRequest request, Model model,
                             @PathVariable(value = "selectItem") String selectItem) {

        return "redirect:/profile/addproblem/" + selectItem;
    }

    /**
     * 添加题目描述界面
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "description", method = RequestMethod.GET)
    public String addProblemDescription(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        model.addAttribute("sidebarItem", "description");
        return "profile/addproblem/addproblem";
    }

    /**
     * 提交题目描述
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "description", method = RequestMethod.POST)
    public String submitProblemDescription(HttpServletRequest request, Model model) {
        //add problemset

        ProblemModel problem = new ProblemModel();
        problem.setUserId(((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getUserId());
        problem.setContestId(0);
        problem.setTitle(request.getParameter("title"));
        problem.setDescription(request.getParameter("description"));
        problem.setInputDescription(request.getParameter("inputdescription"));
        problem.setOutputDescription(request.getParameter("outputdescription"));
        problem.setSampleInput(request.getParameter("sampleinput"));
        problem.setSampleOutput(request.getParameter("sampleoutput"));
        problem.setSpecialJudge("NO");
        problem.setVisiable("YES");
        problem.setMemoryLimit(65536);
        problem.setTimeLimit(2000);

        if (problemService.insertProblem(problem)) {
            if ((Integer) request.getSession().getAttribute("currentProblemId") != problem.getProblemId()) {
                request.getSession().setAttribute("currentProblemId", problem.getProblemId());
            }
        }

        return "redirect:/profile/addproblem/metainfo";
    }

    /**
     * 添加题目元信息界面
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "metainfo", method = RequestMethod.GET)
    public String addProblemMetaInfo(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        model.addAttribute("sidebarItem", "metainfo");
        return "profile/addproblem/addproblem";
    }

    /**
     * 提交题目元信息
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "metainfo", method = RequestMethod.POST)
    public String submitProblemMetaInfo(HttpServletRequest request, Model model) {
        //add metainfo
        ProblemModel problem = new ProblemModel();
        problem.setTimeLimit(Integer.parseInt(request.getParameter("timeLimit")));
        problem.setMemoryLimit(Integer.parseInt(request.getParameter("memoryLimit")));
        problem.setSpecialJudge(request.getParameter("specialJudge"));
        problem.setVisiable(request.getParameter("visiable"));
        problem.setHint(request.getParameter("hint"));

        Integer problemId = (Integer) request.getSession().getAttribute("currentProblemId");

        if (problemId != null) {
            problemService.updateProblemByProblemId(problemId, problem);
        }

        return "redirect:/profile/addproblem/testcase";
    }

    /**
     *
     * 添加题目测试数据
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "testcase", method = RequestMethod.GET)
    public String addProblemTestCase(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        model.addAttribute("sidebarItem", "testcase");

        Integer problemId = (Integer) request.getSession().getAttribute("currentProblemId");

        if (problemId != null) {
            List<TestCaseModel> testcases = testCaseService.queryTestCaseByProblemId(problemId);

            if (testcases != null) {
                request.getSession().setAttribute("testCaseNumber", testcases.size());
                Collections.sort(testcases, new Comparator<TestCaseModel>() {
                    @Override
                    public int compare(TestCaseModel o1, TestCaseModel o2) {
                        return (o1.getCaseNumber() < o2.getCaseNumber() ? -1 :
                                (o1.getCaseNumber() > o2.getCaseNumber() ? 1 : 0));
                    }
                });
            } else {
                request.getSession().setAttribute("testCaseNumber", 0);
            }

            model.addAttribute("testcases", testcases);
        }

        return "profile/addproblem/addproblem";
    }

    /**
     * 提交题目测试数据
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "testcase", method = RequestMethod.POST)
    public String submitProblemTestCase(HttpServletRequest request, Model model) {
        //add test cases
        TestCaseModel testcase = new TestCaseModel();
        testcase.setTestData(request.getParameter("testData"));
        testcase.setStandardOutput(request.getParameter("standardOutput"));

        Integer problemId = (Integer) request.getSession().getAttribute("currentProblemId");

        if (problemId == null) {
            problemId = problemService.queryLatestProblemIdByUserId(((UserModel) request
                    .getSession()
                    .getAttribute("currentUser"))
                    .getUserId());
        }

        testcase.setProblemId(problemId);
        Integer testCaseNumber = (Integer)request.getSession().getAttribute("testCaseNumber");
        testcase.setCaseNumber(testCaseNumber + 1);

        if (testCaseService.insertTestCase(testcase)) {
            request.getSession().setAttribute("testCaseNumber", testCaseNumber + 1);
        }

        return "redirect:/profile/addproblem/testcase";
    }

    /**
     * 退出
     *
     * @param request
     * @return String
     * */
    @RequestMapping(value = "exit")
    public String exit(HttpServletRequest request) {
        request.getSession().removeAttribute("testCaseNumber");
        request.getSession().removeAttribute("currentProblemId");
        return "redirect:/profile/myproblem";
    }
}
