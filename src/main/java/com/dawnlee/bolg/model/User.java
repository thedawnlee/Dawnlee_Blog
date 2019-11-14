package com.dawnlee.bolg.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String accountid;
    private String token;
    private Long gmtcreate;
    private Long gmtmodify;
    private String avatarUrl;
}
