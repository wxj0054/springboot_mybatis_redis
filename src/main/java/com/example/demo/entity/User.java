package com.example.demo.entity;

import java.io.Serializable;

/**
 * Created by wxj on 2018/8/9.
 */
public class User implements Serializable {

    private Integer uid;
    private String usename;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", usename='" + usename + '\'' +
                '}';
    }
}
