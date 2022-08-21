package com.xinrg.JavaMonitor.service;

import com.xinrg.JavaMonitor.dao.ThreadRepository;
import com.xinrg.JavaMonitor.entity.JstackEntity;
import com.xinrg.JavaMonitor.entity.KVEntity;
import com.xinrg.JavaMonitor.model.ThreadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadService {
    @Autowired
    private ThreadRepository threadRepository;
    public List<ThreadEntity> findAllByPid(String pid) {
        return threadRepository.findAllByPid(pid);
    }
    public void insert(String pid, String date, JstackEntity jstack) {
        ThreadEntity threadEntity = new ThreadEntity();
        threadEntity.setPid(pid);
        threadEntity.setDate(date);
        threadEntity.setTotal(jstack.getTotal());
        threadEntity.setRUNNABLE(jstack.getRUNNABLE());
        threadEntity.setTIMED_WAITING(jstack.getTIMED_WAITING());
        threadEntity.setWAITING(jstack.getWAITING());
        threadEntity.setBLOCKED(jstack.getBLOCKED());
        threadRepository.save(threadEntity);
    }
    public void clearAll() {
        threadRepository.deleteAll();
    }
}
