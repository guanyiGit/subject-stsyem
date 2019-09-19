package com.system.mapper;

import com.system.entity.TSubjectOption;
import com.system.pojo.rt.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import com.system.utils.ReqPage;

import java.util.List;
@Mapper
public interface RtDb {


    /**
     * 查考试列表
     *
     * @param qReqPage 分页
     * @param examType 考试分类 --> 0.交通法考试 1民法考试 ....（待定）
     * @param examStatus 考试状态 --> 0.未发布  1.已发布  2.已关闭
     * @return
     */
    List<Rt> findRtList(@Param("qReqPage") ReqPage.QReqPage qReqPage, @Param("examType") Integer examType,@Param("examStatus") Integer[] examStatus);

    /**
     * 查考试列表 count
     *
     * @param qReqPage 分页
     * @param examType 考试分类 --> 0.交通法考试 1民法考试 ....（待定）
     * @param examStatus 考试状态 --> 0.未发布  1.已发布  2.已关闭
     * @return
     */
    Integer findRtListCount(@Param("qReqPage") ReqPage.QReqPage qReqPage, @Param("examType") Integer examType, @Param("examStatus") Integer[] examStatus);

    /**
     * 查成绩列表
     *
     * @param qReqPage 分页
     * @param examId   所属考试id
     * @param isPass   是否及格 0.及格 1.未及格
     * @return
     */
    List<Score> findScoresByexId(@Param("qReqPage") ReqPage.QReqPage qReqPage, @Param("examId") Integer examId, @Param("isPass") Integer isPass);

    /**
     * 查成绩列表 count
     *
     * @param qReqPage 分页
     * @param examId   所属考试id
     * @param isPass   是否及格 0.及格 1.未及格
     * @return
     */
    Integer findScoresByexIdCount(@Param("qReqPage") ReqPage.QReqPage qReqPage, @Param("examId") Integer examId, @Param("isPass") Integer isPass);


    /**
     * 查看考试记录列表
     *
     * @param page 分页
     * @param exId 考生id
     * @param examId 考试id
     * @return
     */
    List<ExamRecord> findExamRecord(@Param("page") ReqPage page, @Param("exId") Integer exId,@Param("examId") Integer examId);

    /**
     * 查看考试记录列表 count
     *
     * @param page 分页
     * @param exId 考生id
     * @param examId 考试id
     * @return
     */
    Integer findExamRecordCount(@Param("page") ReqPage page, @Param("exId") Integer exId, @Param("examId")Integer examId);


    /**
     * 查看考试结果明细
     *
     * @param page     分页
     * @param recordId 考试记录id
     * @param result   考试结果 0.正确 1.错误
     * @return
     */
    List<SubScore> findExamRecordDateils(@Param("page") ReqPage page, @Param("recordId") Integer recordId, @Param("result") Integer result);

    /**
     * 查看考试结果明细 count
     *
     * @param page     分页
     * @param recordId 考试记录id
     * @param result   考试结果 0.正确 1.错误
     * @return
     */
    Integer findExamRecordDateilsCount(@Param("page") ReqPage page, @Param("recordId") Integer recordId, @Param("result") Integer result);

    /**
     * 查看考生考试详情
     * @param answerId
     * @return
     */
    ExamineeExaminationInfo findTestPaperDateilByAnswerId(@Param("answerId") Integer answerId);

    List<TSubjectOption> selectTSubjectOptions(@Param("subjectId") Integer subjectId);

}
