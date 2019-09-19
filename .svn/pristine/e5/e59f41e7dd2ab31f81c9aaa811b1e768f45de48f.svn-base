package com.system.service.examination.impl;

import com.system.entity.TAnswer;
import com.system.entity.TExaminations;
import com.system.entity.TRecord;
import com.system.entity.TSubjectOption;
import com.system.mapper.TExaminationsMapper;
import com.system.mapper.TRecordMapper;
import com.system.pojo.examination.CheckExamIsCanJoin;
import com.system.pojo.examination.ExaminationDetail;
import com.system.pojo.examination.ExaminationVo;
import com.system.pojo.subject.SubjectVo;
import com.system.service.examination.ExaminationService;
import com.system.subjectMenu.SubjectType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.system.utils.ReqPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private TExaminationsMapper examinationsMapper;

    @Autowired
    private TRecordMapper recordMapper;

    @Override
    public List<ExaminationVo> getExaminations(ReqPage reqPage, Integer examineeId, Integer examType) throws Exception {
        List<TExaminations> examinations = examinationsMapper.findExaminations(reqPage,examType);
        List<ExaminationVo> examinationVos = new ArrayList<>();
        if(examinations == null || examinations.size() ==0){
            return examinationVos;
        }
        examinations.stream().forEach( item ->{
            ExaminationVo examinationVo = new ExaminationVo();
            BeanUtils.copyProperties(item,examinationVo);
            examinationVo.setCanJoin(false);
            boolean canJoin = this.checcIsCanJoin(item, examineeId);
            examinationVo.setCanJoin(canJoin);

            examinationVos.add(examinationVo);
        });
        return examinationVos;


    }

    @Override
    public TExaminations getExaminations(Integer examId) throws Exception {
        TExaminations examinations = examinationsMapper.selectByPrimaryKey(examId);
        return examinations;
    }

    /**
     * 检查答案是否正确
     * @param answerArr 考生答案
     * @param standardAnswerArr 标准答案
     * @return  0 正确  1.错误
     */
    private int checkOptionIsTrue(List<String> answerArr,List<String> standardAnswerArr){
       if (answerArr.size()> standardAnswerArr.size()){
           return 1;
       }else if (answerArr == null ||answerArr.size() == 0){
           return 1;
       }else {
           int flag = 0 ;
           for (String answer: answerArr) {
               boolean contains = standardAnswerArr.contains(answer);
               if (!contains){
                   flag = 1;
               }
           }
           return flag;
       }
    }

    @Override
    public ExaminationDetail getExamResultMenu(Integer examineeId, Integer examId,Integer seq) throws Exception {
        ExaminationDetail examResultMenu = examinationsMapper.getExamResultMenu(examineeId, examId,seq);

        List<SubjectVo> subjectVos = examResultMenu.getTestPaperVo().getSubjectVos();

        subjectVos.stream().forEach( subject ->{
            //如果是简答题，不效验答案
            if (subject.getSunjectType() .equals(SubjectType.BriefAnswer.getType())){
                //默认为正确的
                subject.setIsTrue(0);
            }else {
                List<TSubjectOption> options = subject.getOptions();
                //获取标准答案
                List<String> standardAnswerArr = options.stream()
                        .filter(x -> x!=null && x.getIsTrue() == 0)
                        .map(y -> y.getOptionNumber()).collect(Collectors.toList());

                //获取考生答案
                List<String> answerArr = subject.getCheckOption().stream()
                        .filter(x -> x != null)
                        .map(y -> y.getExamineeAnswer())
                        .collect(Collectors.toList());
                int i = this.checkOptionIsTrue(answerArr, standardAnswerArr);
                subject.setIsTrue(i);
                subject.setOptions(options);
            }


        });
        examResultMenu.getTestPaperVo().setSubjectVos(subjectVos);
        return examResultMenu;
    }



    @Override
    public CheckExamIsCanJoin checkExamIsCanJoin(Integer examineeId, Integer examId) throws Exception {
        CheckExamIsCanJoin checkExamIsCanJoin = new CheckExamIsCanJoin();
        TExaminations examinations = examinationsMapper.selectByPrimaryKey(examId);
        boolean canJoin = this.checcIsCanJoin(examinations, examineeId);
        checkExamIsCanJoin.setCanJoin(canJoin);
        checkExamIsCanJoin.setExamId(examinations.getExamId());
        checkExamIsCanJoin.setExamineeId(examineeId);
        return checkExamIsCanJoin;
    }

    /**
     * 判断当前考试是否可以继续考试
     * @param examinations
     * @param examineeId
     * @return
     */
    public  boolean checcIsCanJoin(TExaminations examinations,Integer examineeId){
        boolean canJoin = false;

        //当前时间是否在生效时间之后
        boolean isAfter = new Date().after(examinations.getEffectDate());

        boolean isBefore = true;
        if (examinations.getFailureDate() != null){
            //当前时间是否在失效时间之前
            isBefore = new Date().before(examinations.getFailureDate());
        }

        if (examinations.getExamStatus() == 1){
            if ( isAfter && isBefore ){
                List<TRecord> records = recordMapper.findByExamineeIdAndExamId(examineeId, examinations.getExamId());
                Integer recordsCount = 0;
                if (records != null && records.size()>0){
                    recordsCount = records.size();
                }
                //答题次数等于0或者答题记录小于答题次数，可以继续答题
                if ( examinations.getAnswersNumber() == 0 || recordsCount < examinations.getAnswersNumber()){
                    canJoin = true;
                }
            }
        }
        return canJoin;

    }
}
