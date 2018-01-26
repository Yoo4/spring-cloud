package com.springcloud.auth.bean;

import com.springcloud.common.util.jwt.IJWTInfo;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 16:13
 */

public class ClientInfo implements IJWTInfo{
    String clientId;
    String secret;
    String name;
    String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String getUniqueName() {
        return clientId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
