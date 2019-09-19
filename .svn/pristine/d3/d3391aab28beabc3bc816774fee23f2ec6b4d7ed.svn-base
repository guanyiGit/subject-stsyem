package com.system.service.examinee.impl;

import com.alibaba.fastjson.JSONObject;
import com.system.entity.TExaminee;
import com.system.errorCode.ExamineeErrorCode;
import com.system.mapper.TExamineeMapper;
import com.system.service.examinee.ExanineeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.system.utils.R;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
@Service
public class ExamineeServiceImpl implements ExanineeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TExamineeMapper examineeMapper;

//    @Autowired
//    private RestTemplate restTemplate;


    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.appsecret}")
    private String appsecret;


    @Override
    public R insertExaminee(TExaminee examinee) throws Exception {
        examinee.setCreateTime(new Date());
        examineeMapper.insertSelective(examinee);
        return R.ok(examinee);
    }

    @Override
    public R insertExaminee(String openId) throws Exception {
        TExaminee examinee = new TExaminee();
        examinee.setCreateTime(new Date());
        examinee.setOpenid(openId);
        examineeMapper.insertSelective(examinee);
        return R.ok(examinee);
    }

    @Override
    public TExaminee findExamineeByOpenId(String openId) throws Exception {
        TExaminee tExaminee = examineeMapper.selectByOpenId(openId);
        return tExaminee;
    }

    @Override
    public R login(String name, String phone, String openId) throws Exception {
        TExaminee examinee = examineeMapper.selectByOpenId(openId);
//        TExaminee examinee = examineeMapper.selectByPhone(phone);
        if (examinee == null){
            examinee = new TExaminee();
            examinee.setName(name);
            examinee.setPhone(phone);
            examinee.setOpenid(openId);
            R r = this.insertExaminee(examinee);
            return r;
        }else if (examinee!= null && examinee.getName() == null && examinee.getPhone() == null){
            examinee.setName(name);
            examinee.setPhone(phone);
            examineeMapper.updateByPrimaryKeySelective(examinee);
            return R.ok(examinee);
        }
        if (!examinee.getName().equals(name)){
            return R.error(ExamineeErrorCode.COMMON_ACCOUNT_ERROR.getCode(),ExamineeErrorCode.COMMON_ACCOUNT_ERROR.getDesc());
        }
        return R.ok(examinee);
    }

    @Override
    public R checkOpenId(String code, String openId) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        logger.info("code 传参: "+ code);
        logger.info("openId 传参: "+ openId);
        if (openId == null){
            String url  = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appsecret +"&js_code="+code+"&grant_type=authorization_code";
            String template = restTemplate.getForObject(url, String.class);
            logger.info("template 参数接受: "+ template);
            JSONObject jsonObject = JSONObject.parseObject(template);
            openId = jsonObject.get("openid").toString();
            logger.info("openId 参数接受: "+ openId);
        }
        TExaminee examinee = examineeMapper.selectByOpenId(openId);
        if ( examinee!= null && examinee.getName() != null && examinee.getPhone() != null){
            return R.ok(201,examinee);
        }else if(examinee!= null && examinee.getName() == null && examinee.getPhone() == null){
            return R.ok(202,examinee);
        }
        //创建一个虚拟考生
        examinee = new TExaminee();
        examinee.setOpenid(openId);
        examinee.setCreateTime(new Date());
        examineeMapper.insertSelective(examinee);
        return R.ok(202,examinee);
    }
}
