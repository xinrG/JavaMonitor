package com.xinrg.JavaMonitor.entity;

public class JstackEntity {
    private String id;
    private int total;
    private int RUNNABLE;
    private int TIMED_WAITING;
    private int WAITING;
    private int BLOCKED;

    public JstackEntity(String id, int total, int RUNNABLE, int TIMED_WAITING, int WAITING, int BLOCKED) {
        this.id = id;
        this.total = total;
        this.RUNNABLE = RUNNABLE;
        this.TIMED_WAITING = TIMED_WAITING;
        this.WAITING = WAITING;
        this.BLOCKED = BLOCKED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
