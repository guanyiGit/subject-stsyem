package com.system.service.examinee;

import com.system.entity.TExaminee;
import com.system.utils.R;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
public interface ExanineeService {

    R insertExaminee(TExaminee examinee)throws Exception;

    R insertExaminee(String openId)throws Exception;

    TExaminee findExamineeByOpenId(String openId)throws Exception;

    R login(String name, String phone, String openId)throws Exception;

    R checkOpenId(String code ,String openId)throws Exception;

}
