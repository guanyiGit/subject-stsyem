package com.system.pojo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author pengyu
 * @Date 2019/7/23
 * @Description
 */
@Data
public class ExcelOptionPojo {

    @Excel(name = "选项序号",orderNum = "1")
    private String optionNumber;

    @Excel(name = "选项值",orderNum = "2")
    private String optionValue;

    @Excel(name = "选项是否正确",orderNum = "3",replace = {"正确_0","错误_1"})
    private String isTrue;

}
