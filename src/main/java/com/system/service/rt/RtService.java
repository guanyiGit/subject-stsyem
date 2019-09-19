package com.system.service.rt;

import com.github.pagehelper.PageInfo;
import com.system.pojo.rt.*;
import com.system.utils.ReqPage;

public interface RtService {

    /**
     * 查考试列表
     *
     * @param qReqPage 分页
     * @param examType 考试分类 --> 0.问卷调查 1.在线考试 2.知识竞赛
     * @param examStatus 考试状态 --> 0.未发布  1.已发布  2.已关闭
     * @return
     */
    PageInfo<Rt> findRtList(ReqPage.QReqPage qReqPage, Integer examType, Integer[] examStatus);


    /**
     * 查成绩列表
     * @param qReqPage 分页
     * @param examId 所属考试id
     * @param isPass 是否及格 0.及格 1.未及格
     * @return
     */
    PageInfo<Score> findScoresByexId(ReqPage.QReqPage qReqPage, Integer examId, Integer isPass);

    /**
     * 查看我的考试记录列表
     *
     * @param page   分页
     * @param exId 考生id
     * @param examId 考试id
     * @return
     */
    PageInfo<ExamRecord> findExamRecord(ReqPage page, Integer exId, Integer examId);

    /**
     * 查看考试结果明细
     *
     * @param page     分页
     * @param recordId 考试记录id
     * @param result   考试结果 0.正确 1.错误
     * @return
     */
    PageInfo<SubScore> findExamRecordDateil(ReqPage page, Integer recordId, Integer result);

    /**
     *
     * @param answerId 考生答案表主键id
     * @return
     */
    ExamineeExaminationInfo findTestPaperDateilByAnswerId(Integer answerId);
}
