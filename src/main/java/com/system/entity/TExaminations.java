package com.system.entity;




import java.util.Date;

public class TExaminations {
    private Integer examId;

    private Integer examType;

    private String examName;

    private Integer paperId;

    private Integer answersNumber;

    private Integer examTime;

    private Integer passScore;

    private Integer echoSetting;

    private Date effectDate;

    private Date failureDate;

    private String examExplain;

    private Integer examStatus;

    private Integer examCreater;

    private Date createTime;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getExamType() {
        return examType;
    }

    public void setExamType(Integer examType) {
        this.examType = examType;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName == null ? null : examName.trim();
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getAnswersNumber() {
        return answersNumber;
    }

    public void setAnswersNumber(Integer answersNumber) {
        this.answersNumber = answersNumber;
    }

    public Integer getExamTime() {
        return examTime;
    }

    public void setExamTime(Integer examTime) {
        this.examTime = examTime;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Integer getEchoSetting() {
        return echoSetting;
    }

    public void setEchoSetting(Integer echoSetting) {
        this.echoSetting = echoSetting;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public Date getFailureDate() {
        return failureDate;
    }

    public void setFailureDate(Date failureDate) {
        this.failureDate = failureDate;
    }

    public String getExamExplain() {
        return examExplain;
    }

    public void setExamExplain(String examExplain) {
        this.examExplain = examExplain == null ? null : examExplain.trim();
    }

    public Integer getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(Integer examStatus) {
        this.examStatus = examStatus;
    }

    public Integer getExamCreater() {
        return examCreater;
    }

    public void setExamCreater(Integer examCreater) {
        this.examCreater = examCreater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}