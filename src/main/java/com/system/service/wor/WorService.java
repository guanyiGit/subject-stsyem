package com.system.service.wor;

import com.github.pagehelper.PageInfo;
import com.system.entity.TSubjectBank;
import com.system.entity.TSubjectOption;
import com.system.pojo.wor.SubBankInUser;
import com.system.pojo.wor.SubInOpts;
import com.system.utils.ReqPage;

import java.util.List;

public interface WorService {

    /**
     * 查查试题列表列表
     *
     * @param page
     * @param subjectMode       0.交通法规, 1.民法知识 2.刑法知识 3.趣味知识 4.其他知识(可关联字典表)
     * @param subjectDifficulty 0.简单 ,1.一般 2.困难
     * @return
     */
    PageInfo<SubBankInUser> list(ReqPage.QReqPage page, Integer subjectMode, Integer subjectDifficulty);

    /**
     * 查选项
     *
     * @param subjectId
     * @return
     */
    List<TSubjectOption> findOptsBySId(int subjectId);

    /**
     * 保存题库
     *
     * @param subInOpts
     * @return
     */
    String savesOrOpts(List<SubInOpts> subInOpts);

    /**
     * 删除题库和选项
     *
     * @param subjectIds
     * @param isdelOpts  是否删除题库选项
     * @return
     */
    boolean batchDelSubsAndOptsBySubIds(int[] subjectIds, boolean isdelOpts);

    /**
     * 查试题详情
     *
     * @param subjectId 题库id
     * @return
     */
    TSubjectBank detail(Integer subjectId);

}
