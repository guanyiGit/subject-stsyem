package com.system.pojo.testPaper;

import com.system.entity.TTestPaper;
import com.system.pojo.subject.SubjectVo;

import java.util.List;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
public class TestPaperVo extends TTestPaper {

    private List<SubjectVo> subjectVos;

    public List<SubjectVo> getSubjectVos() {
        return subjectVos;
    }

    public void setSubjectVos(List<SubjectVo> subjectVos) {
        this.subjectVos = subjectVos;
    }
}
