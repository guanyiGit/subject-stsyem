package com.system.mapper.testPaper;

import com.system.pojo.testPaper.TestPaperVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
@Mapper
public interface TestPaperMapper {
    /**
     * 查询试卷详情(题目及选项)
     * @param testPaperId
     * @return
     */
    TestPaperVo getTestPaperDetail(@Param("testPaperId") Integer testPaperId);

}
