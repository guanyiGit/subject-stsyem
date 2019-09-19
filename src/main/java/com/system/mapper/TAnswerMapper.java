package com.system.mapper;

import com.system.entity.TAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TAnswerMapper {

    int deleteByPrimaryKey(Integer answerId);

    int insert(TAnswer record);

    int insertSelective(TAnswer record);

    TAnswer selectByPrimaryKey(Integer answerId);

    int updateByPrimaryKeySelective(TAnswer record);

    int updateByPrimaryKey(TAnswer record);

    /**
     * 批量添加答案
     * @param answers
     * @throws Exception
     */
    void answerAdd(List<TAnswer> answers)throws Exception;
}