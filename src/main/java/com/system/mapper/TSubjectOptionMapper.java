package com.system.mapper;

import com.system.entity.TSubjectOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TSubjectOptionMapper {

    int deleteByPrimaryKey(Integer optionId);

    int insert(TSubjectOption record);

    int insertSelective(TSubjectOption record);

    TSubjectOption selectByPrimaryKey(Integer optionId);

    int updateByPrimaryKeySelective(TSubjectOption record);

    int updateByPrimaryKey(TSubjectOption record);
}