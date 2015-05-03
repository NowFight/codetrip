package org.codetrip.service.contestproblem;

import org.codetrip.common.enumerate.ContestStatus;
import org.codetrip.common.so.ContestProblemSO;
import org.codetrip.common.so.ProblemStatisticSO;
import org.codetrip.common.util.DateUtil;
import org.codetrip.common.util.Time;
import org.codetrip.common.vo.ContestProblemVO;
import org.codetrip.common.vo.ContestVO;
import org.codetrip.common.vo.ProblemVO;
import org.codetrip.dao.contest.ContestDao;
import org.codetrip.dao.contestproblem.ContestProblemDao;
import org.codetrip.dao.problem.ProblemDao;
import org.codetrip.dao.statistic.ProblemStatisticDao;
import org.codetrip.model.contest.ContestModel;
import org.codetrip.model.contestproblem.ContestProblemModel;
import org.codetrip.model.problem.ProblemModel;
import org.codetrip.model.statistic.ProblemStatisticModel;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by RuFeng on 2015/4/22.
 */
@Service
public class ContestProblemServiceImp implements ContestProblemService {

    private final static Logger LOG = Logger.getLogger(ContestProblemService.class.getName());

    @Autowired
    private ContestProblemDao contestProblemDao;

    @Autowired
    private ProblemDao problemDao;

    @Autowired
    private ProblemStatisticDao statisticDao;

    @Autowired
    private ContestDao contestDao;

    @Autowired
    private Mapper dozerMapper;

    /**
     * 批量添加比赛题目
     *
     * @param contestId
     * @param problemIds
     */
    @Override
    public void batchAddProblem(Long contestId, List<Long> problemIds) {
        if (problemIds != null) {
            if (contestId != null) {
                for (Long problemId : problemIds) {
                    ContestProblemModel contestProblem = new ContestProblemModel();
                    contestProblem.setContestId(contestId);
                    contestProblem.setProblemId(problemId);
                    contestProblemDao.insert(contestProblem);
                    ProblemStatisticModel statistic = new ProblemStatisticModel();
                    statistic.setContestId(contestId);
                    statistic.setProblemId(problemId);
                    statistic.init();
                    statisticDao.insert(statistic);
                }
            } else {
                LOG.warning("contest is null when add problems to contest");
            }
        } else {
            LOG.warning("problemIds is null when add problems to contest");
        }
    }

    /**
     * 列出比赛中包含的题目
     *
     * @param contestId
     * @return List
     */
    @Override
    public List<ProblemVO> listContestProblems(Long contestId) {
        ContestProblemSO so = new ContestProblemSO();
        so.setContestId(contestId);
        List<ContestProblemModel> contestProblems = contestProblemDao.findBySO(so);

        Collections.sort(contestProblems, new Comparator<ContestProblemModel>() {
            @Override
            public int compare(ContestProblemModel o1, ContestProblemModel o2) {
                return o1.getId() < o2.getId() ? -1 : (o1.getId() == o2.getId() ? 0 : 1);
            }
        });

        if (!contestProblems.isEmpty()) {
            List<ProblemVO> problemVOs = new ArrayList<ProblemVO>();
            for (ContestProblemModel contestProblem : contestProblems) {
                ProblemModel problem = problemDao.find(contestProblem.getProblemId());
                if (problem != null) {
                    ProblemVO vo = dozerMapper.map(problem, ProblemVO.class);
                    vo.setContestProblemId(contestProblem.getId());
                    ProblemStatisticSO statisticSO = new ProblemStatisticSO();
                    statisticSO.setProblemId(problem.getId());
                    statisticSO.setContestId(contestId);
                    List<ProblemStatisticModel> statistics = statisticDao.findBySO(statisticSO);
                    if (!statistics.isEmpty()) {
                        vo.setAccept(statistics.get(0).getAccept());
                        vo.setSubmissions(statistics.get(0).getSubmissions());
                    } else {
                        LOG.warning(String.format("problem ID = %d has no statistic", problem.getId()));
                    }
                    problemVOs.add(vo);
                } else {
                    LOG.warning("problem ID : " + contestProblem.getProblemId() + " is not in problem set");
                }
            }
            return problemVOs;
        } else {
            return null;
        }
    }

    /**
     * 取得比赛中的题目
     *
     * @param contestProblemId
     * @return ProblemVO
     */
    @Override
    public ProblemVO getProblem(Long contestProblemId) {
        ContestProblemModel contestProblem = contestProblemDao.find(contestProblemId);
        if (contestProblem != null) {
            ProblemModel problem = problemDao.find(contestProblem.getProblemId());
            if (problem != null) {
                ProblemVO vo = dozerMapper.map(problem, ProblemVO.class);
                ProblemStatisticSO statisticSO = new ProblemStatisticSO();
                statisticSO.setProblemId(problem.getId());
                statisticSO.setContestId(contestProblem.getContestId());
                List<ProblemStatisticModel> statistics = statisticDao.findBySO(statisticSO);
                if (!statistics.isEmpty()) {
                    vo.setAccept(statistics.get(0).getAccept());
                    vo.setSubmissions(statistics.get(0).getSubmissions());
                } else {
                    LOG.warning(String.format("problem ID = %d has no statistic", problem.getId()));
                }
                return vo;
            } else {
                LOG.warning("problem is null with problem id = " + contestProblem.getProblemId());
            }
        } else {
            LOG.warning("contestProblem is null when get contest problem");
        }
        return null;
    }

    /**
     * 获得比赛信息
     *
     * @param contestProblemId
     * @return ContestVO
     */
    @Override
    public ContestVO getContest(Long contestProblemId) {
        ContestProblemModel contestProblem = contestProblemDao.find(contestProblemId);
        if (contestProblem != null) {
            ContestModel contest = contestDao.find(contestProblem.getContestId());
            if (contest != null) {
                ContestVO vo = dozerMapper.map(contest, ContestVO.class);
                try {
                    Time startTime = new Time(DateUtil.DateParser(contest.getStartTime(), "yyyy/MM/dd HH:mm"));
                    Time endTime = new Time(DateUtil.DateParser(contest.getEndTime(), "yyyy/MM/dd HH:mm"));
                    Time currentTime = new Time(DateUtil.DateParser(
                            new SimpleDateFormat("yyyy/MM/dd HH:mm").format(System.currentTimeMillis()), "yyyy/MM/dd HH:mm"));

                    if (startTime.after(currentTime)) {
                        vo.setStatus(ContestStatus.NOT_START);
                    } else if (endTime.before(currentTime)) {
                        vo.setStatus(ContestStatus.DONE);
                    } else {
                        vo.setStatus(ContestStatus.RUNNING);
                    }
                } catch (Exception err) {
                    throw new RuntimeException(err);
                }
                return vo;
            } else {
                LOG.warning("contest is null with contest id = " + contestProblem.getContestId());
            }
        } else {
            LOG.warning("contestProblem is null");
        }
        return null;
    }

    /**
     * 获得比赛题目的关系
     *
     * @param contestProblemId
     * @return ContestProblemVO
     */
    @Override
    public ContestProblemVO getContestProblem(Long contestProblemId) {
        ContestProblemModel contestProblem = contestProblemDao.find(contestProblemId);
        if (contestProblem != null) {
            return dozerMapper.map(contestProblem, ContestProblemVO.class);
        } else {
            LOG.warning("contestProblem is null");
        }
        return null;
    }
}
