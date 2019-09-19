package com.system.service.user;

import com.system.VO.UpdateUserStatusVO;
import com.system.VO.UserVO;
import com.system.entity.TRole;
import com.system.entity.TUser;
import com.system.utils.R;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, Object> findUserList(Integer pageNum, Integer pageSize, Integer role, String searchKey);

    int insert(UserVO user);

    int update(TUser user);

    UserVO detail(Integer id);

    List<TRole> findRoleList();

    /**
     * 修改用户状态
     */
    int updateStatus(Integer userId,Integer status);
    //登陆
    R login(String name, String password);
}
