package com.system.controller;

import com.system.entity.TExaminee;
import com.system.service.examinee.ExanineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.system.utils.R;

/**
 * @author pengyu
 * @Date 2019/6/20
 * @Description
 */
@RestController
@RequestMapping("/biz/examinee")
public class ExamineeController {

    @Autowired
    private ExanineeService exanineeService;

    /**
     * 新增考生
     * @param examinee
     * @return id:考生主键id
     */
    @PostMapping("")
    public R insertExaminee(@RequestBody TExaminee examinee){
        try{
            R r = exanineeService.insertExaminee(examinee);
            return r;
        }
        catch (Exception e){
            return  R.error();
        }
    }

    /**
     * 根据openId创建一个虚拟考生
     * @param openId
     * @return
     */
    @GetMapping("/add/{openId}")
    public R insertExaminee(@PathVariable String openId){
        try {
            R r = exanineeService.insertExaminee(openId);
            return r;
        } catch (Exception e) {
            return R.error();
        }
    }


    /**
     * 获取openid及验证openid是否有效
     * @param code
     * @param openId
     * @return
     */
    @GetMapping("/checkOpenId")
    public R findExamineeByOpenId(String code, String openId){
        try {
            R r = exanineeService.checkOpenId(code, openId);
            return R.ok(r);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @GetMapping("/login/{name}/{phone}/{openId}")
    public R login(@PathVariable String name,@PathVariable String phone,@PathVariable String openId){
        try {
            R r = exanineeService.login(name, phone, openId);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

}
