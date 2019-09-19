package com.system.controller.score;

import com.system.service.rt.RtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.system.utils.R;
import com.system.utils.ReqPage;

@RestController
@RequestMapping("/biz/score")
public class RtController {

    @Autowired
    private RtService rtService;

    /**
     * 查考试列表
     *
     * @param qReqPage 分页
     * @param examType 考试分类 --> 0.问卷调查 1.在线考试 2.知识竞赛
     * @param examStatus 考试状态 --> 0.未发布  1.已发布  2.已关闭
     * @return
     */
    @GetMapping("/list")
    public R list(ReqPage.QReqPage qReqPage, @RequestParam(required = false) Integer examType,
             @RequestParam(required = false) Integer[] examStatus) {
        try {
            return R.ok(rtService.findRtList(qReqPage, examType,examStatus));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 查成绩列表
     *
     * @param qReqPage 分页
     * @param examId   所属考试id
     * @param isPass   是否及格 0.及格 1.未及格
     * @return
     */
    @GetMapping("/users/{examId}")
    public R scores(ReqPage.QReqPage qReqPage, @PathVariable Integer examId, @RequestParam(required = false) Integer isPass) {
        try {
            return R.ok(rtService.findScoresByexId(qReqPage, examId, isPass));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 查看我的考试记录列表
     *
     * @param exId 考生id
     * @param examId 考试id
     * @return
     */
    @GetMapping("/user/dateils/{exId}")
    public R scoresDateils(ReqPage page, @PathVariable Integer exId,@RequestParam(required = false) Integer examId) {
        try {
            return R.ok(rtService.findExamRecord(page, exId,examId));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 查看考试结果明细
     *
     * @param page     分页
     * @param recordId 考试记录id
     * @param result   考试结果 0.正确 1.错误
     * @return
     */
    @GetMapping("/exam/details/{recordId}")
    public R examDetails(ReqPage page, @PathVariable Integer recordId, @RequestParam(required = false) Integer result) {
        try {
            return R.ok(rtService.findExamRecordDateil(page, recordId,result));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     *
     * @param answerId 考生答案表主键id
     * @return
     */
    @GetMapping("/exam/details/info/{answerId}")
    public R scoresInfo(@PathVariable Integer answerId) {
        try {
            return R.ok(rtService.findTestPaperDateilByAnswerId(answerId));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

}
