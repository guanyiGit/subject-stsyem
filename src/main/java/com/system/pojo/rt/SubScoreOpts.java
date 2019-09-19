package com.system.pojo.rt;

public class SubScoreOpts {
    /**
     * 选项id
     */
    private Integer optionId;
    /**
     * 题目选项序号
     */
    private String optionSeq;

    /**
     * 题目选项值
     */
    private String optVal;
    /**
     * 题目正确性  0.是 1.否
     */
    private Integer isTrue;

    public String getOptionSeq() {
        return optionSeq;
    }

    public void setOptionSeq(String optionSeq) {
        this.optionSeq = optionSeq;
    }

    public String getOptVal() {
        return optVal;
    }

    public void setOptVal(String optVal) {
        this.optVal = optVal;
    }

    public Integer getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(Integer isTrue) {
        this.isTrue = isTrue;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }
}