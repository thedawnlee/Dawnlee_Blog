package com.dawnlee.bolg.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
public class User implements Serializable {

    private int id;
    private String name;
    private String accountid;
    private String token;
    private Long gmtcreate;
    private Long gmtmodify;
    private String avatarUrl;
}
