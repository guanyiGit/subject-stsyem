package com.system.service.testPaperLib.impl;

import com.system.mapper.testPaper.TestPaperMapper;
import com.system.pojo.testPaper.TestPaperVo;
import com.system.service.testPaperLib.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
@Service
public class TestPaperServiceImpl implements TestPaperService {

    @Autowired
    private TestPaperMapper testPaperMapper;

    @Override
    public TestPaperVo getTestPaperDetail(Integer testPaperId) throws Exception{
        TestPaperVo testPaperDetail = testPaperMapper.getTestPaperDetail(testPaperId);
        return testPaperDetail;
    }



}
