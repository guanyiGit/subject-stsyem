package com.system.pojo.examination;

import com.system.entity.TExaminations;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
public class ExaminationVo extends TExaminations {

    private Boolean canJoin;

    public Boolean getCanJoin() {
        return canJoin;
    }

    public void setCanJoin(Boolean canJoin) {
        this.canJoin = canJoin;
    }
}
