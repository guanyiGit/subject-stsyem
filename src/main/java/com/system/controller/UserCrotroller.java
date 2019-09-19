package com.system.controller;

import com.system.VO.UpdateUserStatusVO;
import com.system.VO.UserVO;
import com.system.entity.TRole;
import com.system.entity.TUser;
import com.system.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.system.utils.R;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/biz/user")
public class UserCrotroller extends BaseController{
    @Autowired
    private UserService userService;



    /**
     * 查看用户列表
     * @param  pageNum
     * @param  pageSize
     * @param  type
     * @param  status
     * @param  searchKey
     */
    @RequestMapping("/findUserList")
    public R findUserList(Integer pageNum,Integer pageSize,Integer role,String searchKey){
        try{
            Map<String,Object> m=userService.findUserList(pageNum,pageSize,role,searchKey);
            return R.ok(m);
        }
        catch (Exception e){
            e.printStackTrace();
            return  R.error();
        }
    }

    /**
     * 新增用户
     */
    @RequestMapping("/insert")
    public R insert(UserVO user){
        try{
            int a=userService.insert(user);
            return R.ok(a);
        }
        catch (Exception e){
            e.printStackTrace();
            return  R.error();
        }
    }

    /**
     * 修改用户
     */
    @RequestMapping("/update")
    public R update(TUser user){
        try{
            int a=userService.update(user);
            return R.ok(a);
        }
        catch (Exception e){
            return  R.error();
        }
    }
    /**
     * 查看用户
     */
    @RequestMapping("/detail")
    public R detail(Integer id){
        try{
            UserVO vo=userService.detail(id);
            return R.ok(vo);
        }
        catch (Exception e){
            return  R.error();
        }
    }


    /**
     * 查看角色列表
     */
    @RequestMapping("/findRoleList")
    public R findRoleList(){
        try{
            List<TRole> m=userService.findRoleList();
            return R.ok(m);
        }
        catch (Exception e){
            return  R.error();
        }
    }


    /**
     * 修改用户状态
     */
    @RequestMapping("/updateStatus")
    public R updateStatus(Integer userId,Integer status){
        try{
            int a=userService.updateStatus(userId,status);
            return R.ok(a);
        }
        catch (Exception e){
            return  R.error();
        }
    }



}
