package com.springcloud.common.util.jwt;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 9:56
 */

public class JWTInfo implements Serializable,IJWTInfo{
    private String username;
    private String userId;
    private String name;

    public JWTInfo(String username, String userId, String name) {
        this.username = username;
        this.userId = userId;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUniqueName() {
        return username;
    }

    @Override
    public String getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JWTInfo JWTInfo = (JWTInfo) o;
        return Objects.equals(username, JWTInfo.username) &&
                Objects.equals(userId, JWTInfo.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userId);
    }


}
