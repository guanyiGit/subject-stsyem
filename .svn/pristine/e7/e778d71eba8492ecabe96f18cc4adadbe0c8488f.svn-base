package com.system.controller;

import com.github.pagehelper.util.StringUtil;
import com.system.entity.TSubjectRefPaper;
import com.system.entity.testPaperLib.ParmQuestion;
import com.system.entity.testPaperLib.TestPapperClassification;
import com.system.service.testPaperLib.TestPaperLibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.system.utils.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//犬证相关
@Controller
@RequestMapping("/biz/testPaperLib")
public class TestPaperLibController {
    @Autowired
    TestPaperLibService testPaperLibService;
    //试卷库列表查询
    @RequestMapping("/selectDogCardHandleList")
    @ResponseBody
    public R selectDogCardHandleList(Integer paperType, Integer paperMode, String input, Integer num, Integer size) {
        if (StringUtil.isEmpty(input)) {
            input = null;
        }
        Map<String,Object> map = new HashMap<>();
        try {
            map = testPaperLibService.selectTTestPaperList(paperType, paperMode, input, num, size);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(map);
    }

    //查询题库每种类型或难度的数量
    @RequestMapping("/selectDifficultyOrTypeNum")
    @ResponseBody
    public R selectDifficultyOrTypeNum(Integer type) {
        Map<String,List<TestPapperClassification>> map =null;
        try {
            map = testPaperLibService.selectDifficultyOrTypeNum(type);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(map);
    }

    //查询随机抽选的题目id 也就是试卷试题关联表对象的集合
    @RequestMapping("/selectTSubjectRefPapers")
    @ResponseBody
    public R selectTSubjectRefPapers(@RequestBody ParmQuestion parmQuestion) {
        List<TSubjectRefPaper> list =null;
        try {
            list = testPaperLibService.selectTSubjectRefPapers(parmQuestion);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(list);
    }
    //创建试卷设置题目分值列表查询
    @RequestMapping("/creTePaSetScoreList")
    @ResponseBody
    public R createTestPapperSetScoreList(@RequestBody ParmQuestion parmQuestion) {
        Map<String,Object> map = new HashMap<>();
        try {
            map = testPaperLibService.createTestPapperSetScoreList(parmQuestion);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(map);
    }
    //创建试卷自选题左边列表
    @RequestMapping("/createTestPapperLeftList")
    @ResponseBody
    public R createTestPapperLeftList(@RequestBody ParmQuestion parmQuestion) {
        Map<String,Object> map = new HashMap<>();
        try {
            map = testPaperLibService.createTestPapperLeftList(parmQuestion);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(map);
    }
    //创建试卷
    @RequestMapping("/insertTestPaper")
    @ResponseBody
    public R insertTestPaper(@RequestBody ParmQuestion parmQuestion) {
        try {
            testPaperLibService.insertTestPaper(parmQuestion);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }

    //复制试卷
    @RequestMapping("/copyTestPaper")
    @ResponseBody
    public R copyTestPaper(Integer usrId,Integer paperId,String paperName) {
        try {
            testPaperLibService.copyTestPaper(usrId,paperId,paperName);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }

    //删除试卷
    @RequestMapping("/deleteTestPaper")
    @ResponseBody
    public R deleteTestPaper(@RequestBody List<Integer> paperIds) {
        try {
            testPaperLibService.deleteTestPaper(paperIds);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }

    //查看试卷详情
    @RequestMapping("/selectTestPaperInfo")
    @ResponseBody
    public R selectTestPaperInfo(Integer paperId,Integer paperMode, Integer difficulty, String input, Integer num, Integer size) {
        Map<String,Object> map = new HashMap<>();
        try {
            map = testPaperLibService.selectTestPaperInfo(paperId,paperMode,difficulty,input,num,size);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(map);
    }
    //修改试卷要用的接口：查询某试卷的关联表信息
    @RequestMapping("/querySubjectRefPapers")
    @ResponseBody
    public R querySubjectRefPapers(Integer paperId) {
        List<TSubjectRefPaper> tSubjectRefPapers = null;
        try {
            tSubjectRefPapers = testPaperLibService.querySubjectRefPapers(paperId);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(tSubjectRefPapers);
    }
    //修改试卷
    @RequestMapping("/updateTestPaper")
    @ResponseBody
    public R updateTestPaper(@RequestBody ParmQuestion parmQuestion) {
        try {
            testPaperLibService.updateTestPaper(parmQuestion);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }

    //根据试卷id查找试卷名称
    @RequestMapping("/findPaperById")
    @ResponseBody
    public R findPaperById(Integer id) {
        try {
            String name=testPaperLibService.findPaperById(id);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok();
    }
}
