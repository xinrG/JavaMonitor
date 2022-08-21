package com.xinrg.JavaMonitor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "class_table")
public class ClassEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String pid;
    private String date;
    private String Loaded;
    private String Bytes1;
    private String Unloaded;
    private String Bytes2;
    private String Time1;
    private String Compiled;
    private String Failed;
    private String Invalid;
    private String Time2;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoaded() {
        return Loaded;
    }

    public void setLoaded(String loaded) {
        Loaded = loaded;
    }

    public String getBytes1() {
        return Bytes1;
    }

    public void setBytes1(String bytes1) {
        Bytes1 = bytes1;
    }

    public String getUnloaded() {
        return Unloaded;
    }

    public void setUnloaded(String unloaded) {
        Unloaded = unloaded;
    }

    public String getBytes2() {
        return Bytes2;
    }

    public void setBytes2(String bytes2) {
        Bytes2 = bytes2;
    }

    public String getTime1() {
        return Time1;
    }

    public void setTime1(String time1) {
        Time1 = time1;
    }

    public String getCompiled() {
        return Compiled;
    }

    public void setCompiled(String compiled) {
        Compiled = compiled;
    }

    public String getFailed() {
        return Failed;
    }

    public void setFailed(String failed) {
        Failed = failed;
    }

    public String getInvalid() {
        return Invalid;
    }

    public void setInvalid(String invalid) {
        Invalid = invalid;
    }

    public String getTime2() {
        return Time2;
    }

    public void setTime2(String time2) {
        Time2 = time2;
    }
}
