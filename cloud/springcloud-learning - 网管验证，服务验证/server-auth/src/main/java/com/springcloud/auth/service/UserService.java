package com.springcloud.auth.service;

import com.springcloud.auth.bean.UserInfo;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 14:41
 */

public interface UserService {
    UserInfo login(String username, String password);
}
