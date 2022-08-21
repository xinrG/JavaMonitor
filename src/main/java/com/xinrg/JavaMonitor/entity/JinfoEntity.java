package com.xinrg.JavaMonitor.entity;

import java.util.List;

public class JinfoEntity {
    private List<String> nonDefault;
    private List<String> commandLine;

    public JinfoEntity(List<String> nonDefault, List<String> commandLine) {
        this.nonDefault = nonDefault;
        this.commandLine = commandLine;
    }

    public List<String> getNonDefault() {
        return nonDefault;
    }

    public void setNonDefault(List<String> nonDefault) {
        this.nonDefault = nonDefault;
    }

    public List<String> getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(List<String> commandLine) {
        this.commandLine = commandLine;
    }
}
