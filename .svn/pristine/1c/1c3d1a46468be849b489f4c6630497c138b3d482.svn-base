package com.system.service.record.impl;

import com.system.entity.TAnswer;
import com.system.entity.TExaminations;
import com.system.entity.TRecord;
import com.system.entity.TSubjectOption;
import com.system.mapper.TExaminationsMapper;
import com.system.mapper.TRecordMapper;
import com.system.pojo.record.RecordVo;
import com.system.pojo.sub.SubRefAnswer;
import com.system.pojo.subject.SubjectVo;
import com.system.pojo.testPaper.TestPaperVo;
import com.system.service.answer.AnswerService;
import com.system.service.record.RecordService;
import com.system.service.testPaperLib.TestPaperService;
import com.system.subjectMenu.ExamType;
import com.system.subjectMenu.SubjectType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pengyu
 * @Date 2019/6/21
 * @Description
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private TRecordMapper recordMapper;

    @Autowired
    private TestPaperService testPaperService;

    @Autowired
    private TExaminationsMapper examinationsMapper;

    @Autowired
    private AnswerService answerService;

    @Override
    public TRecord recordAdd(TRecord record) throws Exception {
        record.setCreateTime(new Date());
        record.setSeq(1);

        Integer recordCount = this.getRecordCount(record.getExamineeId(), record.getExamId());
        if (recordCount != null && recordCount != 0){
            record.setSeq(recordCount+1);
        }
        recordMapper.insertSelective(record);
        return record;
    }

    @Override
    public List<TRecord> findRecords(Integer examineeId, Integer examId) throws Exception{
        List<TRecord> records = recordMapper.findByExamineeIdAndExamId(examineeId, examId);
        return records;
    }

    @Override
    public TRecord findRecords(Integer recordId) throws Exception {
        TRecord record = recordMapper.selectByPrimaryKey(recordId);
        return record;
    }

    @Override
    public Integer getRecordCount(Integer examineeId, Integer examId) {
        Integer recordCount = recordMapper.getRecordCount(examineeId, examId);
        return recordCount;
    }

    /**
     * 计算考生得分
     * @param answerArr 考生答案
     * @param standardAnswerArr 标准答案
     * @param score  题目总分
     * @return
     */
    public Float examScore(List<String> answerArr,List<String> standardAnswerArr,float score){
        float newScore = 0f;
        if (answerArr.size() == 0){
            return newScore;
        }
        //如果是单选
        if (standardAnswerArr.size() == 1) {
            if (answerArr.get(0).equals(standardAnswerArr.get(0))){
                newScore = score;
            }
        }else{
            if (answerArr.size() < standardAnswerArr.size()){
                //判断answerArr中的字符是否全在standardAnswerArr中 如果是就得一半分
                //标志，一旦有一个字符不在standardAnswerArr中 就变为 0,不得分
                int flag = 1 ;
                for (String answer: answerArr) {
                    boolean contains = standardAnswerArr.contains(answer);
                    if (!contains){
                        flag = 0;
                    }
                }
                if (flag == 1){
                    newScore=score/2;
                }

            }else if (answerArr.size() == standardAnswerArr.size()){
                //判断answerArr中的字符是否全在standardAnswerArr中 如果是就得一半分
                //标志，一旦有一个字符不在standardAnswerArr中 就变为 0,不得分
                int flag = 1 ;
                for (String answer: answerArr) {
                    boolean contains = standardAnswerArr.contains(answer);
                    if (!contains){
                        flag = 0;
                    }
                }
                if (flag == 1){
                    newScore=score;
                }
            }
        }
        return newScore;
    }


    @Override
    @Transactional
    public TRecord recordVoAdd(RecordVo recordVo) throws Exception{
        TRecord record = new TRecord();
        BeanUtils.copyProperties(recordVo,record);
        //通过考试id查出当前试卷及题目对应分数
        TExaminations examinations = examinationsMapper.selectByPrimaryKey(recordVo.getExamId());
        //通过paperId获取试卷详情
        TestPaperVo testPaperDetail = testPaperService.getTestPaperDetail(examinations.getPaperId());
        //题目详情
        List<SubjectVo> subjectVos = testPaperDetail.getSubjectVos();
        //考生答案
        List<SubRefAnswer> activeSubjects = recordVo.getActiveSubject();

        Float score = 0f;
//      如果是问卷调差，不做分数统计
        if (!examinations.getExamType().equals(ExamType.QuestionExam.getType())){

            for (SubjectVo subjectVo:subjectVos) {
                //如果是简答题
                if (subjectVo.getSunjectType().equals(SubjectType.BriefAnswer.getType())){
                    continue;
                }
                //获取当前题目的正确选项选项
                List<TSubjectOption> options = subjectVo.getOptions().stream().filter(y -> y.getIsTrue() == 0)
                        .collect(Collectors.toList());
                //获取正确答案列表
                List<String> standardAnswerArr = options.stream()
                        .filter(y->y!=null)
                        .map(y->y.getOptionNumber())
                        .collect(Collectors.toList());

                //获取考生当前题目答案
                List<SubRefAnswer> subRefAnswers = activeSubjects.stream().filter(y -> y.getSubjectId().equals(subjectVo.getSubjectId()))
                        .collect(Collectors.toList());
                if (subRefAnswers != null && subRefAnswers.size()>0){
                    //获取考生答案
                    List<String> answerArr = subRefAnswers.get(0).getAnswerList().stream()
                            .filter(y->y!=null)
                            .map(y -> y.getExamineeAnswer())
                            .collect(Collectors.toList());
                    //获取当前题目得分
                    Float examScore = this.examScore(answerArr, standardAnswerArr, subjectVo.getScore());
                    score += examScore;
                }
            }
            record.setScore(score.intValue());
            //如果得分大于等于及格分数
            if (score >= examinations.getPassScore() ){
                record.setIsPass(0);
            }else {
                record.setIsPass(1);
            }
        }
        TRecord record1 = this.recordAdd(record);

        List<TAnswer> answers = new ArrayList<>();
        activeSubjects.stream().forEach(x -> {
            x.getAnswerList().stream().forEach(y -> {
                TAnswer answer = new TAnswer();
                answer.setRecordId(record1.getRecordId());
                answer.setSubjectId(x.getSubjectId());
                answer.setCreateTime(new Date());
                //如果是简答题
                if (x.getSunjectType().equals(SubjectType.BriefAnswer.getType())){
                    answer.setOpinion(y.getOpinion());
                }else {
                    answer.setExamineeAnswer(y.getExamineeAnswer());
                    answer.setResult(y.getResult());
                }
                answers.add(answer);
            });
        });
        answerService.answerAdd(answers);
        return record1;
    }


    @Override
    public RecordVo getRecordVo(Integer examineeId, Integer examId) throws Exception {
        RecordVo recordVo = recordMapper.getRecordVo(examineeId, examId);
        return recordVo;
    }
}
