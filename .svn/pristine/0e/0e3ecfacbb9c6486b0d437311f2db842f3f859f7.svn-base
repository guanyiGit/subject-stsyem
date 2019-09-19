package com.system.mapper;

import com.system.entity.TSubjectRefPaper;
import com.system.entity.TTestPaper;
import com.system.entity.testPaperLib.ParmQuestion;
import com.system.entity.testPaperLib.QuestionSetScore;
import com.system.entity.testPaperLib.TestPapperClassification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TTestPaperMapper {

    int deleteByPrimaryKey(Integer paperId);

    int insert(TTestPaper record);

    int insertSelective(TTestPaper record);

    TTestPaper selectByPrimaryKey(Integer paperId);

    int updateByPrimaryKeySelective(TTestPaper record);

    int updateByPrimaryKey(TTestPaper record);

    /**
     * 试卷列表
     * @param paperType//试卷分类
     * @param paperMode//组卷方式
     * @param input//查询字段 卷名称
     * @param start
     * @param size
     * @return
     */
    List<TTestPaper> selectTTestPaperList(@Param("paperType") Integer paperType,@Param("paperMode") Integer paperMode,@Param("input") String input,@Param("start") Integer start,@Param("size") Integer size);
    /**
     * 试卷列表总条数
     * @param paperType//试卷分类
     * @param paperMode//组卷方式
     * @param input//查询字段 卷名称
     * @param start
     * @param size
     * @return
     */
    Integer selectTTestPaperCount(@Param("paperType") Integer paperType,@Param("paperMode") Integer paperMode,@Param("input") String input,@Param("start") Integer start,@Param("size") Integer size);

    //查询题库每种类型题目的数量
    List<TestPapperClassification> selectTypeNum();
    //查询题库每种难度题目的数量
    List<TestPapperClassification> selectDifficultyNum(@Param("type") Integer type);
    //根据试题类型查试题id集合
    List<TSubjectRefPaper> selectSubjectIdsByType(@Param("type") Integer type, @Param("num") Integer num);
    //根据试题难度查试题id集合
    List<TSubjectRefPaper> selectSubjectIdsByDifficulty(@Param("difficulty") Integer difficulty,@Param("num") Integer num,@Param("type") Integer type);
    /**
     * 创建试卷设置题目分值列表查询
     * @param type
     * @param difficulty
     * @param input
     * @param start
     * @param size
     * @return
     */
    List<QuestionSetScore> createTestPapperSetScoreList(@Param("type") Integer type, @Param("difficulty") Integer difficulty, @Param("input") String input, @Param("start") Integer start, @Param("size") Integer size, @Param("subjectIds") List<Integer> subjectIds);
    //创建试卷设置题目分值列表总条数查询
    Integer createTestPapperSetScoreCount(@Param("type") Integer type,@Param("difficulty") Integer difficulty,@Param("input") String input,@Param("start") Integer start,@Param("size") Integer size,@Param("subjectIds") List<Integer> subjectIds);
    /**
     * 创建试卷自选题左边列表
     * @param type
     * @param difficulty
     * @param input
     * @param start
     * @param size
     * @return
     */
    List<QuestionSetScore> createTestPapperNotInList(@Param("type") Integer type, @Param("difficulty") Integer difficulty, @Param("input") String input, @Param("start") Integer start, @Param("size") Integer size,@Param("subjectIds") List<Integer> subjectIds);
    //创建试卷自选题左边列表总数
    Integer createTestPapperNotInCount(@Param("type") Integer type,@Param("difficulty") Integer difficulty,@Param("input") String input,@Param("start") Integer start,@Param("size") Integer size,@Param("subjectIds") List<Integer> subjectIds);
    //插入试卷表信息
    Integer insertTestPaper(ParmQuestion parmQuestion);
    //插入试卷试题关联表信息
    void insertSubjectRefPaper(List<TSubjectRefPaper> subjectRefPapers);

    //根据试卷id查询试题关联表信息
    List<TSubjectRefPaper> selectSubjectRefPaper(@Param("paperId") Integer paperId);
    List<TSubjectRefPaper> selectSubjectRefPaperr(@Param("paperId") Integer paperId);

    //删除试卷表信息
    void deleteTestPaperInfo(@Param("paperIds") List<Integer> paperIds);
    //删除试卷试题关联表信息
    void deleteSubjectRefPaper(@Param("paperIds") List<Integer> paperIds);

    //查看试卷详情试题列表
    List<QuestionSetScore> selectPaperSubjectList(@Param("paperId") Integer paperId,@Param("paperMode") Integer paperMode, @Param("difficulty") Integer difficulty, @Param("input") String input, @Param("start") Integer start, @Param("size") Integer size);
    //查看试卷详情试题列表总数
    Integer selectPaperSubjectCount(@Param("paperId") Integer paperId,@Param("paperMode") Integer paperMode,@Param("difficulty") Integer difficulty,@Param("input") String input,@Param("start") Integer start,@Param("size") Integer size);
    //修改试卷表
    void updateTestPaper(ParmQuestion parmQuestion);

    String findPaperById(Integer id);

    //修改试题状态
    void updateSubjectBank(@Param("ids") List<TSubjectRefPaper> ids);

}