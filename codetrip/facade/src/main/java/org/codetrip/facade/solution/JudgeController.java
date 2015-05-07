package org.codetrip.facade.solution;

import org.codetrip.common.enumerate.JudgeResult;
import org.codetrip.common.so.TestCaseSO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.common.vo.SolutionVO;
import org.codetrip.common.vo.TestCaseVO;
import org.codetrip.model.solution.SolutionModel;
import org.codetrip.service.problem.ProblemService;
import org.codetrip.service.solution.SolutionService;
import org.codetrip.service.testcase.TestCaseService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/5/6.
 */
@Controller
@RequestMapping(value = "judge")
public class JudgeController {

    private static Logger LOG = Logger.getLogger(JudgeController.class.getName());

    @Autowired
    private SolutionService solutionService;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private ProblemService problemService;

    /**
     * 提供solution记录
     *
     * @param model
     * @result String
     * */
    @RequestMapping(value = "get")
    public String get(Model model) {
        List<SolutionVO> solutionVOList = solutionService.getQueueSolutions();
        JSONObject jsonObject = new JSONObject();

        List<JSONObject> jsonObjects = new ArrayList<JSONObject>();
        try {
            for (SolutionVO vo : solutionVOList) {
                ProblemVO problem = problemService.viewProblem(vo.getProblemId());
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("id", vo.getId());
                jsonObj.put("language", vo.getLanguage());
                jsonObj.put("time_limit", problem.getTimeLimit());
                jsonObj.put("memory_limit", problem.getMemoryLimit());

                jsonObj.put("code", vo.getCodeContext());
                List<String> datas = new ArrayList<String>();
                List<String> outputs = new ArrayList<String>();
                List<TestCaseVO> testCaseVOs = testCaseService.listAllTestCases(vo.getProblemId());
                for (TestCaseVO tvo : testCaseVOs) {
                    datas.add(tvo.getTestData());
                    outputs.add(tvo.getStandardOutput());
                }
                jsonObj.put("datas", datas);
                jsonObj.put("outputs", outputs);
                jsonObjects.add(jsonObj);
            }
            jsonObject.put("solution", jsonObjects);

            model.addAttribute("jsonString", jsonObject.toString());
        }
        catch (JSONException err) {
            LOG.warning("serializa to json error : " + err.toString());
        }
        return "judge";
    }

    /**
     * 提交判题结果
     *
     * @param request
     * @result String
     * */
    @RequestMapping(value = "post")
    public String post(HttpServletRequest request) {
        Long solution_id = Long.parseLong(request.getParameter("solution_id"));
        String compile_info = request.getParameter("compile_info");
        String result = request.getParameter("result");
        Integer time_usage = Integer.parseInt(request.getParameter("time_usage"));
        Integer memory_usage = Integer.parseInt(request.getParameter("memory_usage"));
        SolutionModel solution = new SolutionModel();
        solution.setId(solution_id);
        solution.setUseTime(time_usage);
        solution.setUseMemory(memory_usage);
        solution.setCompileOutput(compile_info);
        if (result.equals("AC")) {
            solution.setResult(JudgeResult.ACCEPT);
        }
        else if (result.equals("WA")) {
            solution.setResult(JudgeResult.WRONG_ANSWER);
        }
        else if (result.equals("CE")) {
            solution.setResult(JudgeResult.COMPILE_ERROR);
        }
        else if (result.equals("TLE")) {
            solution.setResult(JudgeResult.TIME_LIMIT_EXCEEDED);
        }
        else if (result.equals("RE")) {
            solution.setResult(JudgeResult.RUNTIME_ERROR);
        }
        else if (result.equals("PE")) {
            solution.setResult(JudgeResult.PRESENTATION_ERROR);
        }
        solutionService.updateSolution(solution);
        LOG.info("solution : " + solution_id + "\n"
                + "result : " + result + "\n"
                + "time usage : " + time_usage + " ms" + "\n"
                + "memory usage : " + memory_usage + " kb" + "\n"
                + "compile information : " + compile_info);
        return "judge";
    }
}
