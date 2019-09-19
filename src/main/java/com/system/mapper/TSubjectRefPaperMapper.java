package com.system.mapper;

import com.system.entity.TSubjectRefPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TSubjectRefPaperMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TSubjectRefPaper record);

    int insertSelective(TSubjectRefPaper record);

    TSubjectRefPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSubjectRefPaper record);

    int updateByPrimaryKey(TSubjectRefPaper record);
}