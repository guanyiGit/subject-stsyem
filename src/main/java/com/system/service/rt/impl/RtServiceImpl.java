package com.system.service.rt.impl;

import com.github.pagehelper.PageInfo;
import com.system.mapper.RtDb;
import com.system.pojo.rt.*;
import com.system.service.rt.RtService;
import com.system.utils.ReqPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RtServiceImpl implements RtService {

    @Autowired
    private RtDb rtDb;

    @Override
    public PageInfo<Rt> findRtList(ReqPage.QReqPage qReqPage, Integer examType, Integer[] examStatus) {
        PageInfo<Rt> page = new PageInfo<>(rtDb.findRtList(qReqPage, examType, examStatus));
        page.setTotal(rtDb.findRtListCount(qReqPage, examType, examStatus));
        return page;
    }

    @Override
    public PageInfo<Score> findScoresByexId(ReqPage.QReqPage qReqPage, Integer examId, Integer isPass) {
        PageInfo<Score> page = new PageInfo<>(rtDb.findScoresByexId(qReqPage, examId, isPass));
        page.setTotal(rtDb.findScoresByexIdCount(qReqPage, examId, isPass));
        return page;
    }

    @Override
    public PageInfo<ExamRecord> findExamRecord(ReqPage page, Integer exId, Integer examId) {
        PageInfo<ExamRecord> pageInfo = new PageInfo<>(rtDb.findExamRecord(page, exId,examId));
        pageInfo.setTotal(rtDb.findExamRecordCount(page, exId,examId));
        return pageInfo;
    }

    @Override
    public PageInfo<SubScore> findExamRecordDateil(ReqPage page, Integer recordId, Integer result) {
        PageInfo<SubScore> pageInfo = new PageInfo<>(rtDb.findExamRecordDateils(page, recordId, result));
        pageInfo.setTotal(rtDb.findExamRecordDateilsCount(page, recordId, result));
        return pageInfo;
    }

    @Override
    public ExamineeExaminationInfo findTestPaperDateilByAnswerId(Integer answerId) {
        ExamineeExaminationInfo examineeExaminationInfo = new ExamineeExaminationInfo();
        try {
            examineeExaminationInfo = rtDb.findTestPaperDateilByAnswerId(answerId);
            examineeExaminationInfo.setList(rtDb.selectTSubjectOptions(examineeExaminationInfo.getSubjectId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return examineeExaminationInfo;
    }
}
