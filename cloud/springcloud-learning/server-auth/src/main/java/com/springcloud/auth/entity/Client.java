package com.springcloud.auth.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 14:37
 */

public class Client {
    @Id
    private int id;

    private String code;

    private String secret;

    private String name;

    private String locked;

    private String description;

    @Column(name = "crt_time")
    private Date crtTime;

    @Column(name = "crt_user")
    private Date crtUser;

    @Column(name = "crt_name")
    private Date crtName;

    @Column(name = "crt_host")
    private String crtHost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(Date crtUser) {
        this.crtUser = crtUser;
    }

    public Date getCrtName() {
        return crtName;
    }

    public void setCrtName(Date crtName) {
        this.crtName = crtName;
    }

    public String getCrtHost() {
        return crtHost;
    }

    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }
}
