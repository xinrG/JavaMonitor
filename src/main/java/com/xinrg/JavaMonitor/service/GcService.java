package com.xinrg.JavaMonitor.service;

import com.xinrg.JavaMonitor.dao.GcRepository;
import com.xinrg.JavaMonitor.entity.KVEntity;
import com.xinrg.JavaMonitor.model.GcEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GcService {
    @Autowired
    private GcRepository gcRepository;
    public List<GcEntity> findAllByPid(String pid) {
        return gcRepository.findAllByPid(pid);
    }
    public void insert(String pid, String date, List<KVEntity> jstat_gc) {
        GcEntity gcEntity = new GcEntity();
        gcEntity.setPid(pid);
        gcEntity.setDate(date);
        gcEntity.setS0C(jstat_gc.get(0).getValue());
        gcEntity.setS1C(jstat_gc.get(1).getValue());
        gcEntity.setS0U(jstat_gc.get(2).getValue());
        gcEntity.setS1U(jstat_gc.get(3).getValue());
        gcEntity.setEC(jstat_gc.get(4).getValue());
        gcEntity.setEU(jstat_gc.get(5).getValue());
        gcEntity.setOC(jstat_gc.get(6).getValue());
        gcEntity.setOU(jstat_gc.get(7).getValue());
        gcEntity.setMC(jstat_gc.get(8).getValue());
        gcEntity.setMU(jstat_gc.get(9).getValue());
        gcEntity.setCCSC(jstat_gc.get(10).getValue());
        gcEntity.setCCSU(jstat_gc.get(11).getValue());
        gcEntity.setYGC(jstat_gc.get(12).getValue());
        gcEntity.setYGCT(jstat_gc.get(13).getValue());
        gcEntity.setFGC(jstat_gc.get(14).getValue());
        gcEntity.setFGCT(jstat_gc.get(15).getValue());
        gcEntity.setGCT(jstat_gc.get(16).getValue());
        gcRepository.save(gcEntity);
    }
    public void clearAll() {
        gcRepository.deleteAll();
    }
}
