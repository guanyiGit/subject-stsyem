package com.system.controller;

import com.system.entity.TExaminations;
import com.system.pojo.examination.CheckExamIsCanJoin;
import com.system.pojo.examination.ExaminationDetail;
import com.system.pojo.examination.ExaminationVo;
import com.system.service.examination.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.system.utils.R;
import com.system.utils.ReqPage;

import java.util.List;

/**
 *
 * 考试Controller
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
@RestController
@RequestMapping("/biz/examination")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;


    /**
     * 查询考试(考生)
     * @param reqPage  分页参数
     * @param examineeId 考试id
     * @param examType
     * @return
     */
    @GetMapping("/list")
    public R getExaminations(ReqPage reqPage, @RequestParam("examineeId")Integer examineeId,@RequestParam("examType")Integer examType){
        try {
            List<ExaminationVo> examinations = examinationService.getExaminations(reqPage, examineeId,examType);
            return R.ok(examinations);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 查询考试详情
     * @param examId
     * @return
     */
    @GetMapping("/{examId}")
    public R getExaminations(@PathVariable Integer examId){
        try {
            TExaminations examinations = examinationService.getExaminations(examId);
            return R.ok(examinations);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }


    @GetMapping("/ExamResultMenu/{examineeId}/{examId}/{seq}")
    public R getExamResultMenu(@PathVariable Integer examineeId,@PathVariable Integer examId,@PathVariable Integer seq){
        try {
            ExaminationDetail examResultMenu = examinationService.getExamResultMenu(examineeId, examId,seq);
            return R.ok(examResultMenu);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }


    @GetMapping("/CheckExamIsCanJoin/{examineeId}/{examId}")
    public R checkExamIsCanJoin(@PathVariable Integer examineeId,@PathVariable Integer examId){
        try {
            CheckExamIsCanJoin canJoin = examinationService.checkExamIsCanJoin(examineeId, examId);
            return R.ok(canJoin);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }
}
