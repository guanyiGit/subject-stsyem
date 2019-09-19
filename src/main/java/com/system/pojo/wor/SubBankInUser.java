package com.system.pojo.wor;

import com.system.entity.TSubjectBank;

public class SubBankInUser extends TSubjectBank {

    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 用户名
     */
    private String uname;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
