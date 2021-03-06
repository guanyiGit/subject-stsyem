package com.system.mapper;

import com.system.entity.TRecord;
import com.system.pojo.record.RecordVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TRecordMapper {

    /**
     * 删除记录
     * @param achieveId
     * @return
     */
    int deleteByPrimaryKey(Integer achieveId);

    /**
     * 添加考试记录
     * @param record
     * @return
     */
    int insert(TRecord record);

    /**
     * 添加考试记录
     * @param record
     * @return
     */
    int insertSelective(TRecord record);

    /**
     * 查询记录
     * @param recordId
     * @return
     */
    TRecord selectByPrimaryKey(Integer recordId);

    /**
     * 修改记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TRecord record);

    /**
     * 修改记录
     * @param record
     * @return
     */
    int updateByPrimaryKey(TRecord record);

    /**
     * 查询考试记录
     * @param examineeId 考生id
     * @param examId 考试id
     * @return
     */
    List<TRecord> findByExamineeIdAndExamId(@Param("examineeId") Integer examineeId, @Param("examId") Integer examId);


    /**
     * 查询考生考试次数
     * @param examineeId 考试id
     * @param examId  考试id
     * @return
     */
    Integer getRecordCount(@Param("examineeId") Integer examineeId, @Param("examId") Integer examId);


    /**
     * 查询考生考试成绩详情
     * @param examineeId 考试id
     * @param examId  考试id
     * @throws Exception
     * @return
     */
    RecordVo getRecordVo(@Param("examineeId") Integer examineeId, @Param("examId") Integer examId)throws Exception;
}