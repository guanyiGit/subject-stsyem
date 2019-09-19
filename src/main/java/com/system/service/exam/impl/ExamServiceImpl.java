package com.system.service.exam.impl;

import com.system.VO.ExamVO;
import com.system.entity.TExaminations;
import com.system.entity.TExaminee;
import com.system.entity.TRecord;
import com.system.entity.TTestPaper;
import com.system.mapper.TExaminationsMapper;
import com.system.mapper.TExamineeMapper;
import com.system.mapper.TRecordMapper;
import com.system.mapper.TTestPaperMapper;
import com.system.service.exam.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private TExaminationsMapper examMapper;

    @Autowired
    private TExamineeMapper examineeMapper;

    @Autowired
    private TRecordMapper recordMapper;

    @Autowired
    private TTestPaperMapper testPaperMapper;

    /**
     * 查看考试列表
     *
     * @param pageNum
     * @param pageSize
     * @param type
     * @param status
     * @param searchKey
     */
    @Override
    @Transactional
    public Map<String, Object> findExamList(Integer pageNum, Integer pageSize, Integer type, Integer status, String searchKey) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        Integer index = (pageNum - 1) * pageSize;
        //列表
        List<ExamVO> list = examMapper.findExamList(index, pageSize, type, status, searchKey);

        //总数
        Integer total = examMapper.countExam(type, status, searchKey);
        map.put("list", list);
        map.put("total", total);
        return map;
    }

    //新增考试
    @Override
    public int insert(TExaminations examinations) {
        examinations.setCreateTime(new Date());
        TTestPaper paper=new TTestPaper();
        paper.setPaperId(examinations.getPaperId());
        paper.setPaperStatus(1);
        testPaperMapper.updateByPrimaryKeySelective(paper);
        int i = examMapper.insertSelective(examinations);
        return i;
    }

    /**
     * 修改考试
     */
    @Override
    public int update(TExaminations examinations) {
        int i = examMapper.updateByPrimaryKeySelective(examinations);
        return i;
    }

    /**
     * 删除考试
     */
    @Override
    public int delete(Integer id) {
        int i = examMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 查看考试
     *
     * @param id
     * @return
     */
    @Override
    public ExamVO detail(Integer id) {
        return examMapper.detail(id);
    }


    /**
     * 新增考试记录
     *
     * @param record
     * @return id:考试记录主键id
     */
    @Override
    public Integer insertExamRecord(TRecord record) {
        recordMapper.insertSelective(record);
        return record.getRecordId();
    }

    @Override
    public Integer updateStatus(Integer id, Integer status,Integer sign) {
        TExaminations exam=new TExaminations();
        exam.setExamId(id);
        exam.setExamStatus(status);
        if(status==2 &&sign==1) {
            exam.setFailureDate(new Date());
        }
        int i=examMapper.updateByPrimaryKeySelective(exam);
        return i;
    }

}
