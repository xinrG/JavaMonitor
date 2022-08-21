package com.xinrg.JavaMonitor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thread_table")
public class ThreadEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String pid;
    private String date;
    private int total;
    private int RUNNABLE;
    private int TIMED_WAITING;
    private int WAITING;
    private int BLOCKED;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRUNNABLE() {
        return RUNNABLE;
    }

    public void setRUNNABLE(int RUNNABLE) {
        this.RUNNABLE = RUNNABLE;
    }

    public int getTIMED_WAITING() {
        return TIMED_WAITING;
    }

    public void setTIMED_WAITING(int TIMED_WAITING) {
        this.TIMED_WAITING = TIMED_WAITING;
    }

    public int getWAITING() {
        return WAITING;
    }

    public void setWAITING(int WAITING) {
        this.WAITING = WAITING;
    }

    public int getBLOCKED() {
        return BLOCKED;
    }

    public void setBLOCKED(int BLOCKED) {
        this.BLOCKED = BLOCKED;
    }
}
