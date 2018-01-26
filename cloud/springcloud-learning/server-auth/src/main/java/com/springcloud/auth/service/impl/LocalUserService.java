package com.springcloud.auth.service.impl;

import com.springcloud.auth.bean.UserInfo;
import com.springcloud.auth.exception.UserInvalidException;
import com.springcloud.auth.mapper.RoleMapper;
import com.springcloud.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 14:41
 */

@Service
public class LocalUserService implements UserService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserInfo login(String username, String password) {
        //此处信息可以从user-center获取，此处为模拟 new UserInfo(username,"1","管理员","123456");
        UserInfo localInfo = roleMapper.login(username);
        if(!localInfo.getPassword().equals(password))
            throw new UserInvalidException("User password Error");
        return localInfo;
    }
}
