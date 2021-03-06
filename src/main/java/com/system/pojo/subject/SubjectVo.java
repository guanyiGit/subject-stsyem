package com.system.pojo.subject;

import com.system.entity.TAnswer;
import com.system.entity.TSubjectBank;
import com.system.entity.TSubjectOption;

import java.util.List;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
public class SubjectVo extends TSubjectBank {

    /**
     * 当前题目分数
     */
    private Integer score;

    private List<TSubjectOption> options;

    /**
     * 考生答案(选项序号)
     */
    private List<TAnswer> checkOption;

    /**
     * 答案是否正确
     * 0  正确
     * 1  错误
     * -1 未选
     */
    private Integer isTrue;

    /**
     * 题目当前编号
     */
    private Integer seq;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<TSubjectOption> getOptions() {
        return options;
    }

    public void setOptions(List<TSubjectOption> options) {
        this.options = options;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public List<TAnswer> getCheckOption() {
        return checkOption;
    }

    public void setCheckOption(List<TAnswer> checkOption) {
        this.checkOption = checkOption;
    }

    public Integer getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
    }
}
