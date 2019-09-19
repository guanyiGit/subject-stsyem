package com.system.pojo.rt;

/**
 * @author pengyu
 * @Date 2019/7/18
 * @Description
 */
public class SourceResults {

    /**
     * 考生的选择  0.A ,1.B, 2.C, 3.D
     */
    private Integer myOptVal;
    /**
     * 考生做题结果  0.正确 1.错误
     */
    private Integer result;

    /**
     * 答案id
     */
    private Integer answerId;

    private String  opinion;

    public Integer getMyOptVal() {
        return myOptVal;
    }

    public void setMyOptVal(Integer myOptVal) {
        this.myOptVal = myOptVal;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
