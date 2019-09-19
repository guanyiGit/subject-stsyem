package com.system.service.answer.impl;

import com.system.entity.TAnswer;
import com.system.mapper.TAnswerMapper;
import com.system.service.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pengyu
 * @Date 2019/6/21
 * @Description
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private TAnswerMapper answerMapper;

    @Override
    public void answerAdd(List<TAnswer> answers) throws Exception {
        if (answers == null || answers.size() == 0){
            return;
        }
        answerMapper.answerAdd(answers);
    }
}
