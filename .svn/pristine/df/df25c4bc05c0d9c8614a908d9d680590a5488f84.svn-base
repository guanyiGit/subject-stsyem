package com.system.service.excel.impl;

import com.system.entity.TSubjectBank;
import com.system.entity.TSubjectOption;
import com.system.mapper.TSubjectBankMapper;
import com.system.mapper.TSubjectOptionMapper;
import com.system.pojo.excel.ExcelSubjectPojo;
import com.system.service.excel.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pengyu
 * @Date 2019/7/24
 * @Description
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private TSubjectBankMapper subjectBankMapper;

    @Autowired
    private TSubjectOptionMapper subjectOptionMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void excelImportSunject(List<ExcelSubjectPojo> excelSubjectPojos,Integer userId) throws Exception{

        List<TSubjectBank> tSubjectBanks = excelSubjectPojos.stream()
                .filter(x -> x != null)
                .map(x -> {
                    TSubjectBank subjectBank = new TSubjectBank();
                    subjectBank.setSunjectType(Integer.parseInt(x.getSunjectType()));
                    subjectBank.setSubjectMode(Integer.parseInt(x.getSubjectMode()));
                    subjectBank.setSubjectContent(x.getSubjectContent());
                    subjectBank.setSubjectAnalysis(x.getSubjectAnalysis());
                    subjectBank.setSubjectDifficulty(Integer.parseInt(x.getSubjectDifficulty()));
                    //默认未使用
                    subjectBank.setSubjectStatus(0);
                    subjectBank.setSubjectCreater(userId);
                    subjectBank.setSubjectCreatetime(new Date());
                    return subjectBank;
                }).collect(Collectors.toList());

        subjectBankMapper.saveSubs(tSubjectBanks);

        List<TSubjectOption> tSubjectOptions = new ArrayList<>();
        tSubjectBanks.stream().filter(x -> x!=null)
                .forEach(x -> {
                    excelSubjectPojos.stream().forEach(y -> {
                        if (y.getSubjectContent().equals(x.getSubjectContent())){
                            //如果不是简答简答题
                            if (!"3".equals(y.getSunjectType())){
                                List<TSubjectOption> collect = y.getOptions().stream().filter(z -> z.getOptionNumber() != null
                                        && !"".equals(z.getOptionNumber()))
                                    .map(z -> {
                                        TSubjectOption subjectOption = new TSubjectOption();
                                        subjectOption.setSubjectId(x.getSubjectId());
                                        subjectOption.setOptionValue(z.getOptionValue());
                                        subjectOption.setIsTrue(Integer.parseInt(z.getIsTrue()));
                                        subjectOption.setOptionNumber(z.getOptionNumber());
                                        subjectOption.setCreateTime(new Date());
                                        return subjectOption;
                                }).collect(Collectors.toList());
                                tSubjectOptions.addAll(collect);
                            }


                        }
                    });
                });

        subjectBankMapper.saveOpts(tSubjectOptions);
    }
}
