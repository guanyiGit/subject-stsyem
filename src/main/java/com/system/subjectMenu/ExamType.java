package com.system.subjectMenu;

/**
 * @author pengyu
 * @Date 2019/7/18
 * @Description
 */
public enum ExamType {
    /**
     * 问卷调查
     */
    QuestionExam(0,"问卷调查"),

    /**
     * 在线考试
     */
    OnLineExam(0,"在线考试"),

    /**
     * 知识竞赛
     */
    CompetExam(2,"知识竞赛");

    private Integer type;

    private String  typeDes;

    ExamType(Integer type, String typeDes) {
        this.type = type;
        this.typeDes = typeDes;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeDes() {
        return typeDes;
    }
}
