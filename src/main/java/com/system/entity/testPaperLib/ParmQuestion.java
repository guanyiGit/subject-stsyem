package com.system.entity.testPaperLib;

import com.system.entity.TSubjectRefPaper;
import com.system.entity.TTestPaper;

import java.util.List;
import java.util.Map;

//创建试卷抽题参数对象
public class ParmQuestion extends TTestPaper {
    private List<TestPapperClassification> typeList;//存放不同类型的试题个数键值对
    private List<TestPapperClassification> difficultyList;//存放不同难度的试题个数键值对
    private List<TSubjectRefPaper> tSubjectRefPapers;//试卷试题关联表集合
    private Integer difficulty;//查询条件：试题难度
    private Integer type;//查询条件：试题类型
    private Integer num;//
    private Integer size;
    private String input;
    private Integer judge;//用来判断试修改还是新增 1是修改

    public List<TestPapperClassification> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TestPapperClassification> typeList) {
        this.typeList = typeList;
    }

    public List<TestPapperClassification> getDifficultyList() {
        return difficultyList;
    }

    public void setDifficultyList(List<TestPapperClassification> difficultyList) {
        this.difficultyList = difficultyList;
    }

    public List<TSubjectRefPaper> gettSubjectRefPapers() {
        return tSubjectRefPapers;
    }

    public void settSubjectRefPapers(List<TSubjectRefPaper> tSubjectRefPapers) {
        this.tSubjectRefPapers = tSubjectRefPapers;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getJudge() {
        return judge;
    }

    public void setJudge(Integer judge) {
        this.judge = judge;
    }
}
