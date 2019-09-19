package com.system.pojo.examination;

/**
 * @author pengyu
 * @Date 2019/6/24
 * @Description
 */
public class CheckExamIsCanJoin {

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 考生id
     */
    private Integer examineeId;

    /**
     * 当前已考试次数
     */
    private Integer examCount;

    /**
     * 是否可以继续考试
     */
    private boolean canJoin;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getExamCount() {
        return examCount;
    }

    public void setExamCount(Integer examCount) {
        this.examCount = examCount;
    }

    public boolean isCanJoin() {
        return canJoin;
    }

    public void setCanJoin(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public Integer getExamineeId() {
        return examineeId;
    }

    public void setExamineeId(Integer examineeId) {
        this.examineeId = examineeId;
    }
}
