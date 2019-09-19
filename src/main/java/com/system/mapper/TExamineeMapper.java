package com.system.mapper;

import com.system.entity.TExaminee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TExamineeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TExaminee record);

    int insertSelective(TExaminee record);

    TExaminee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TExaminee record);

    int updateByPrimaryKey(TExaminee record);

    //根据电话查看考生
    Integer findExamineeByPhone(@Param("phone") String phone);


    TExaminee selectByOpenId(String openId);

    TExaminee selectByNameAndPhone(@Param("name") String name,@Param("phone") String phone);

    TExaminee selectByPhone(@Param("phone") String phone);
}