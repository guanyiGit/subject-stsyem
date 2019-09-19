package com.system.service.testPaperLib;

import com.system.entity.TTestPaper;
import com.system.pojo.testPaper.TestPaperVo;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
public interface TestPaperService {

    /**
     * 查询试卷详情
     * @param testPaperId
     * @return
     * @throws Exception
     */
    TestPaperVo getTestPaperDetail(Integer testPaperId)throws Exception;

}
