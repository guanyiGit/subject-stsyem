package com.system.entity;

import java.util.Date;

public class TAnswer {
    private Integer answerId;

    private Integer recordId;

    private Integer subjectId;

    private String examineeAnswer;

    private Integer result;

    private Date createTime;

    private String opinion;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getExamineeAnswer() {
        return examineeAnswer;
    }

    public void setExamineeAnswer(String examineeAnswer) {
        this.examineeAnswer = examineeAnswer == null ? null : examineeAnswer.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }
}