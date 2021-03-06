package com.system.service.record;

import com.system.entity.TRecord;
import com.system.pojo.record.RecordVo;

import java.util.List;

/**
 * @author pengyu
 * @Date 2019/6/21
 * @Description
 */
public interface RecordService {

    /**
     * 添加考试记录
     * @param record
     * @throws Exception
     */
    TRecord recordAdd(TRecord record)throws Exception;

    /**
     * 查询考生考试记录
     * @param examineeId 考试id
     * @param examId  考试id
     * @throws Exception
     * @return
     */
    List<TRecord> findRecords(Integer examineeId,Integer examId)throws Exception;

    /**
     * 查询考生考试记录
     * @param recordId
     * @return
     * @throws Exception
     */
    TRecord findRecords(Integer recordId)throws Exception;

    /**
     * 查询考生考试次数
     * @param examineeId 考试id
     * @param examId  考试id
     * @throws Exception
     * @return
     */
    Integer getRecordCount(Integer examineeId,Integer examId)throws Exception;

    /**
     * 添加考生考试记录及成绩
     * @param recordVo
     * @return
     * @throws Exception
     */
    TRecord recordVoAdd(RecordVo recordVo)throws Exception;

    /**
     * 查询考生考试成绩详情
     * @param examineeId 考试id
     * @param examId  考试id
     * @throws Exception
     * @return
     */
    RecordVo getRecordVo(Integer examineeId,Integer examId)throws Exception;

}
