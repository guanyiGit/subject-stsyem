package com.system.pojo.examination;

import com.system.entity.TExaminations;
import com.system.pojo.testPaper.TestPaperVo;

/**
 * @author pengyu
 * @Date 2019/6/21
 * @Description
 */
public class ExaminationDetail extends TExaminations {

  private TestPaperVo testPaperVo;

    public TestPaperVo getTestPaperVo() {
        return testPaperVo;
    }

    public void setTestPaperVo(TestPaperVo testPaperVo) {
        this.testPaperVo = testPaperVo;
    }
}
