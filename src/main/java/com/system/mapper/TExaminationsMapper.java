package com.system.mapper;

import com.system.VO.ExamVO;
import com.system.entity.TExaminations;
import com.system.pojo.examination.ExaminationDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.system.utils.ReqPage;

import java.util.List;

@Mapper
public interface TExaminationsMapper {

    int deleteByPrimaryKey(Integer examId);

    int insert(TExaminations record);

    int insertSelective(TExaminations record);


    TExaminations selectByPrimaryKey(Integer examId);

    int updateByPrimaryKeySelective(TExaminations record);

    int updateByPrimaryKey(TExaminations record);

    /**
     * 查看考试列表
     * @param index
     * @param pageSize
     * @param type
     * @param status
     * @param searchKey
     * @return
     */
    List<ExamVO> findExamList(@Param("index") Integer index,@Param("pageSize")Integer pageSize,
                                     @Param("type")Integer type,@Param("status")Integer status,@Param("searchKey")String searchKey);

    /**
     * 查看考试的记录数
     * @param type
     * @param status
     * @param searchKey
     * @return
     */
    Integer countExam(@Param("type")Integer type,@Param("status")Integer status,@Param("searchKey")String searchKey);

    /**
     * 考试详情查询
     * @param id
     * @return
     */
    ExamVO detail(Integer id);

//    /**
//     * 考试查询(默认查询发布中，和已停止的考试)
//     * @param reqPage
//     * @return
//     */
//    List<TExaminations> findExaminations(@Param("reqPage")ReqPage reqPage);

    /**
     * 考试查询(默认查询发布中，和已停止的考试)
     * @param reqPage
     * @param examType 考试类型
     * @return
     */
    List<TExaminations> findExaminations(@Param("reqPage")ReqPage reqPage,@Param("examType")Integer examType);

    /**
     * 查看考生考试详情
     * @param examineeId
     * @param examId
     * @param seq
     * @return
     * @throws Exception
     */
    ExaminationDetail getExamResultMenu(@Param("examineeId")Integer examineeId, @Param("examId")Integer examId,@Param("seq")Integer seq)throws Exception;

}