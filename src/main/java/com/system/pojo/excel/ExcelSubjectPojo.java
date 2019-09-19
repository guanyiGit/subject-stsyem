package com.system.pojo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.List;

/**
 * @author pengyu
 * @Date 2019/7/23
 * @Description
 */
@ExcelTarget("excelSubjectPojo")
@Data
public class ExcelSubjectPojo {

    /**
     * 题目id
     */
    @Excel(name = "序号",orderNum = "1",needMerge = true)
    private String subjectId;

    /**
     * 0.单选  1.多选  2.判断  3.简答
     */
    @Excel(name = "题目类型",orderNum = "2", replace = {"单选_0", "多选_1", "判断_2", "简答_3"},needMerge = true)
    private String sunjectType;

    /**
     * 0.问卷调查 1.在线考试 2.知识竞赛
     */
    @Excel(name = "题目分类",orderNum = "3",replace = {"问卷调查_0", "在线考试_1", "知识竞赛_2"},needMerge = true)
    private String subjectMode;

    @Excel(name = "题目内容", orderNum = "4",needMerge = true)
    private String subjectContent;

//    @Excel(name = "题目图片url",type = 2,width = 40,needMerge = true)
//    private String subjectUrl;

    @ExcelCollection(name = "题目选项", orderNum = "5")
    private List<ExcelOptionPojo> options;

    @Excel(name = "题目解析", orderNum = "6",needMerge = true)
    private String subjectAnalysis;

    /**
     * 0.简单 ,1.一般 2.困难
     */
    @Excel(name = "题目难度",replace = {"简单_0", "一般_1", "困难_2"}, orderNum = "6",needMerge = true)
    private String subjectDifficulty;


}
