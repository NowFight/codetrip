package org.codetrip.facade.profile.editproblem;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RuFeng on 2015/2/15.
 */
@Controller("EditProblemController")
@RequestMapping(value = "profile/addproblem/edit")
public class EditProblemController {

    @Autowired
    private ProblemService problemService;


    @Autowired
    private TestCaseService testCaseService;

    /**
     * 通过题目ID编辑题目
     *
     * @param request
     * @param problemId
     * @return String
     * */
    @RequestMapping(value = "pid/{PID}")
    public String editProblemByPid(HttpServletRequest request, @PathVariable(value = "PID") int problemId) {

        request.getSession().setAttribute("currentProblemId", problemId);

        return "redirect:/profile/addproblem/edit/description";
    }

    /**
     * 题目编辑导航
     *
     * @param request
     * @param model
     * @param selectItem
     * @return String
     * */
    @RequestMapping(value = "/sidebar/{selectItem}", method = RequestMethod.GET)
    public String editProblem(HttpServletRequest request, Model model,
                             @PathVariable(value = "selectItem") String selectItem) {

        return "redirect:/profile/addproblem/edit/" + selectItem;
    }

    /**
     * 显示题目描述
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "description", method = RequestMethod.GET)
    public String viewProblemDescription(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        model.addAttribute("sidebarItem", "description");

        ProblemModel problem = problemService.queryProblemByProblemId((Integer)request
                .getSession()
                .getAttribute("currentProblemId"));

        model.addAttribute("problem", problem);

        return "profile/addproblem/editproblem";
    }

    /**
     * 题目描述进入编辑状态
     *
     * @param request
     * @param model
     * @param editItem
     * @return String
     * */
    @RequestMapping(value = "description/{editItem}")
    public String editDescription(HttpServletRequest request, Model model,
                                   @PathVariable(value = "editItem") String editItem) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        ProblemModel problem = problemService.queryProblemByProblemId((Integer)request
                .getSession()
                .getAttribute("currentProblemId"));

        model.addAttribute("problem", problem);
        model.addAttribute("sidebarItem", "description");
        model.addAttribute("editItem", editItem);
        return "profile/addproblem/editproblem";
    }

    /**
     * 更新题目描述
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "description/update", method = RequestMethod.POST)
    public String updateDescription(HttpServletRequest request, Model model) {
        ProblemModel problem = new ProblemModel();

        problem.setTitle(request.getParameter("title"));
        if (problem.getTitle() == "") {
            problem.setTitle(null);
        }
        problem.setDescription(request.getParameter("description"));
        problem.setInputDescription(request.getParameter("inputdescription"));
        problem.setOutputDescription(request.getParameter("outputdescription"));
        problem.setSampleInput(request.getParameter("sampleinput"));
        problem.setSampleOutput(request.getParameter("sampleoutput"));

        /*防止没有数据更新的情况，映射语句会出问题*/
        if (problem.getTitle() != null || problem.getDescription() != null ||
                problem.getInputDescription() != null || problem.getOutputDescription() != null ||
                problem.getSampleInput() != null || problem.getSampleOutput() != null) {
            problemService.updateProblemByProblemId((Integer)request
                    .getSession()
                    .getAttribute("currentProblemId"), problem);
        }
        return "redirect:/profile/addproblem/edit/description";
    }

    /**
     * 浏览题目元信息
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "metainfo", method = RequestMethod.GET)
    public String viewProblemMetaInfo(HttpServletRequest request, Model model) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        model.addAttribute("sidebarItem", "metainfo");

        ProblemModel problem = problemService.queryProblemByProblemId((Integer)request
                .getSession()
                .getAttribute("currentProblemId"));

        model.addAttribute("problem", problem);

        return "profile/addproblem/editproblem";
    }

    /**
     * 题目元信息进入编辑状态
     *
     * @param request
     * @param model
     * @param editItem
     * @return String
     * */
    @RequestMapping(value = "metainfo/{editItem}")
    public String editMetainfo(HttpServletRequest request, Model model,
                               @PathVariable(value = "editItem") String editItem) {
        model.addAttribute("hasLogined", true);
        model.addAttribute("nikename", ((UserModel) request
                .getSession()
                .getAttribute("currentUser"))
                .getNikeName());

        ProblemModel problem = problemService.queryProblemByProblemId((Integer)request
                .getSession()
                .getAttribute("currentProblemId"));

        model.addAttribute("problem", problem);
        model.addAttribute("sidebarItem", "metainfo");
        model.addAttribute("editItem", editItem);
        return "profile/addproblem/editproblem";
    }

    /**
     * 更新题目元信息
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "metainfo/update", method = RequestMethod.POST)
    public String updateMetainfo(HttpServletRequest request, Model model) {
        ProblemModel problem = new ProblemModel();

        if (request.getParameter("timeLimit") != "" && request.getParameter("timeLimit") != null) {
            problem.setTimeLimit(Integer.parseInt(request.getParameter("timeLimit")));
        }
        if (request.getParameter("memoryLimit") != "" && request.getParameter("memoryLimit") != null) {
            problem.setMemoryLimit(Integer.parseInt(request.getParameter("memoryLimit")));
        }

        problem.setSpecialJudge(request.getParameter("specialJudge"));
        problem.setVisiable(request.getParameter("visiable"));

        problem.setHint(request.getParameter("hint"));

        /*防止没有数据更新的情况，映射语句会出问题*/
        if (problem.getTimeLimit() != null || problem.getMemoryLimit() != null ||
                problem.getSpecialJudge() != null || problem.getVisiable() != null ||
                problem.getHint() != null) {
            problemService.updateProblemByProblemId((Integer) request
                    .getSession()
                    .getAttribute("currentProblemId"), problem);
        }

        return "redirect:/profile/addproblem/edit/metainfo";
    }

    /**
     * 浏览题目测试数据
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "testcase", method = RequestMethod.GET)
    public String viewProblemTestCase(HttpServletRequest request, Model model) {
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

        return "profile/addproblem/editproblem";
    }

    /**
     * 题目测试数据进入编辑模式
     *
     * @param request
     * @param model
     * @param caseNumber
     * @return String
     * */
    @RequestMapping(value = "testcase/{caseNumber}")
    public String editTestCase(HttpServletRequest request, Model model,
                               @PathVariable(value = "caseNumber") int caseNumber) {
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
            model.addAttribute("editItem", "testcase_" + caseNumber);
        }
        return "profile/addproblem/editproblem";
    }

    /**
     * 更新测试数据
     *
     * @param request
     * @param model
     * @param caseNumber
     * @return String
     * */
    @RequestMapping(value = "testcase/update/{caseNumber}", method = RequestMethod.POST)
    public String updateTestCase(HttpServletRequest request, Model model,
                                 @PathVariable(value = "caseNumber") int caseNumber) {

        TestCaseModel testcase = new TestCaseModel();
        testcase.setTestData(request.getParameter("testData"));
        testcase.setStandardOutput(request.getParameter("standardOutput"));

        testCaseService.updateTestCaseByProblemIdAndCaseId(
                (Integer) request.getSession().getAttribute("currentProblemId"),
                caseNumber,
                testcase);

        return "redirect:/profile/addproblem/edit/testcase";
    }

    /**
     * 删除测试数据
     *
     * @param request
     * @param model
     * @param caseNumber
     * */
    @RequestMapping(value = "testcase/remove/{caseNumber}", method = RequestMethod.GET)
    public String removeTestCase(HttpServletRequest request, Model model,
                                 @PathVariable(value = "caseNumber") int caseNumber) {

        testCaseService.deleteTestCaseByProblemIdAndCaseId(
                (Integer) request.getSession().getAttribute("currentProblemId"),
                caseNumber);

        return "redirect:/profile/addproblem/edit/testcase";
    }

    /**
     * 提交测试数据
     *
     * @param request
     * @param model
     * @return String
     * */
    @RequestMapping(value = "testcase/add", method = RequestMethod.POST)
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

        return "redirect:/profile/addproblem/edit/testcase";
    }
}
