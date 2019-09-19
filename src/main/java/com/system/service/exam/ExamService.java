package com.system.service.exam;

import com.system.VO.ExamVO;
import com.system.entity.TExaminations;
import com.system.entity.TExaminee;
import com.system.entity.TRecord;

import java.text.ParseException;
import java.util.Map;

public interface ExamService {

    Map<String, Object> findExamList(Integer pageNum,Integer pageSize,Integer type,Integer status,String searchKey) throws ParseException;

    int insert(TExaminations examinations);

    int update(TExaminations examinations);

    int delete(Integer id);

    ExamVO detail(Integer id);

    /**
     * 新增考试记录
     * @param record
     * @return id:考生主键id
     */
    Integer insertExamRecord(TRecord record);

    /**
     * 更改考试状态
     * @return
     */
    Integer updateStatus(Integer id, Integer status,Integer sign);
}
