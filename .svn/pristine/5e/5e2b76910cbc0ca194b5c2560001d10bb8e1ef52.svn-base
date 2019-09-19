package com.system.service.testPaperLib;


import com.system.entity.TSubjectRefPaper;
import com.system.entity.testPaperLib.ParmQuestion;
import com.system.entity.testPaperLib.TestPapperClassification;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

public interface TestPaperLibService {
    /**
     * 试卷列表
     * @param paperType//试卷分类
     * @param paperMode//组卷方式
     * @param input//查询字段 卷名称
     * @param num
     * @param size
     * @return
     */
    Map<String,Object> selectTTestPaperList(Integer paperType, Integer paperMode, String input, Integer num, Integer size) throws ServerException;

    //查询题库每种类型或难度的数量
    Map<String,List<TestPapperClassification>> selectDifficultyOrTypeNum(Integer type) throws ServerException;

    //查询随机抽选的题目id 也就是试卷试题关联表对象的集合
    List<TSubjectRefPaper> selectTSubjectRefPapers(ParmQuestion parmQuestion) throws ServerException;
    /**
     * 创建试卷设置题目分值列表查询
     * @param parmQuestion
     * @return
     * @throws ServerException
     */
    Map<String,Object> createTestPapperSetScoreList(ParmQuestion parmQuestion) throws ServerException;
    /**
     * 创建试卷自选题左边列表
     * @param parmQuestion
     * @return
     * @throws ServerException
     */
    Map<String,Object> createTestPapperLeftList(ParmQuestion parmQuestion) throws ServerException;

    //创建试卷
    void insertTestPaper(ParmQuestion parmQuestion) throws ServerException;
    //复制试卷
    void copyTestPaper(Integer usrId,Integer paperId,String paperName) throws ServerException;
    //删除试卷
    void deleteTestPaper(List<Integer> paperIds) throws ServerException;
    //查看试卷详情
    Map<String,Object> selectTestPaperInfo(Integer paperId,Integer paperMode, Integer difficulty, String input, Integer num, Integer size) throws ServerException;
    //修改试卷要用的：差选某试卷的关联表信息
    List<TSubjectRefPaper> querySubjectRefPapers(Integer paperId) throws ServerException;
    //修改试卷
    void updateTestPaper(ParmQuestion parmQuestion) throws ServerException;

    String findPaperById(Integer id);
}
