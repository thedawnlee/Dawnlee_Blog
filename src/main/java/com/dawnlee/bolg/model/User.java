package com.dawnlee.bolg.model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String accountid;
    private String token;
    private Long gmt_create;
    private Long gmt_modify;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Long getGmt_modify() {
        return gmt_modify;
    }

    public void setGmt_modify(Long gmt_modify) {
        this.gmt_modify = gmt_modify;
    }
}
