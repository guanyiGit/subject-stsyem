package com.system.mapper;

import com.system.entity.TSubjectBank;
import com.system.entity.TSubjectOption;
import com.system.pojo.wor.SubBankInUser;
import com.system.pojo.wor.SubInOpts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TSubjectBankMapper {

    int deleteByPrimaryKey(Integer subjectId);

    int insert(TSubjectBank record);

    int insertSelective(TSubjectBank record);

    TSubjectBank selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(TSubjectBank record);

    int updateByPrimaryKey(TSubjectBank record);

    /**
     * 查试题列表
     *
     * @param offset
     * @param limit
     * @param keyWord           按照试卷内容搜索
     * @param subjectMode       0.交通法规, 1.民法知识 2.刑法知识 3.趣味知识 4.其他知识(可关联字典表)
     * @param subjectDifficulty 0.简单 ,1.一般 2.困难
     * @return
     */
    List<SubBankInUser> list(
            @Param("offset") int offset,
            @Param("limit") int limit,
            @Param("keyWord") String keyWord,
            @Param("subjectMode") Integer subjectMode,
            @Param("subjectDifficulty") Integer subjectDifficulty);

    /**
     * 查试题列表 count
     *
     * @param offset
     * @param limit
     * @param keyWord           按照试卷内容搜索
     * @param subjectMode       0.交通法规, 1.民法知识 2.刑法知识 3.趣味知识 4.其他知识(可关联字典表)
     * @param subjectDifficulty 0.简单 ,1.一般 2.困难
     */
    Integer listCount(
            @Param("offset") int offset,
            @Param("limit") int limit,
            @Param("keyWord") String keyWord,
            @Param("subjectMode") Integer subjectMode,
            @Param("subjectDifficulty") Integer subjectDifficulty);


    /**
     * 试题option
     *
     * @param subjectId
     * @return
     */
    List<TSubjectOption> findOptsBySId(@Param("subjectId") int subjectId);

    /**
     * 试题保存
     *
     * @param subs
     * @return
     */
    Integer saveSubs (List<? extends TSubjectBank> subs);

    /**
     * 试题选项保存
     *
     * @param opts
     * @return
     */
    Integer saveOpts(@Param("opts") List<TSubjectOption> opts);

    /**
     * 批量删除试题
     * @param subjectIds
     * @return
     */
    Integer batchDelSubsByIds(@Param("subjectIds") int[] subjectIds);

    /**
     * 批量删除试题选项
     * @param subjectIds
     * @return
     */
    Integer batchDelOptsBySubIds(@Param("subjectIds")int[] subjectIds);

    /**
     * 查试题详情
     *
     * @param subjectId 题库id
     * @return
     */
    SubInOpts detail(@Param("subjectId") Integer subjectId);


}
