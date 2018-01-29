package com.springcloud.auth.service;

import com.springcloud.auth.bean.ClientInfo;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 16:11
 */

public interface ClientService {
    public ClientInfo apply(String clientId, String secret);
}
