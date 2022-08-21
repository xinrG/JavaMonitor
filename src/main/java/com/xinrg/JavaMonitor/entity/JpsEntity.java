package com.xinrg.JavaMonitor.entity;

import java.util.List;

public class JpsEntity {
    private String className;
    private String smallName;
    private List<String> params;

    public JpsEntity(String className, String smallName, List<String> params) {
        this.className = className;
        this.smallName = smallName;
        this.params = params;
    }
    public  JpsEntity(List<String> params) {
        this.className = "null";
        this.smallName = "null";
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSmallName() {
        return smallName;
    }

    public void setSmallName(String smallName) {
        this.smallName = smallName;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
