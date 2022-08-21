package com.xinrg.JavaMonitor.service;

import com.xinrg.JavaMonitor.dao.ClassRepository;
import com.xinrg.JavaMonitor.entity.KVEntity;
import com.xinrg.JavaMonitor.model.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;
    public List<ClassEntity> findAllByPid(String pid) {
        return classRepository.findAllByPid(pid);
    }
    public void insert(String pid, String date, List<KVEntity> jstat_class) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setPid(pid);
        classEntity.setDate(date);
        classEntity.setLoaded(jstat_class.get(0).getValue());
        classEntity.setBytes1(jstat_class.get(1).getValue());
        classEntity.setUnloaded(jstat_class.get(2).getValue());
        classEntity.setBytes2(jstat_class.get(3).getValue());
        classEntity.setTime1(jstat_class.get(4).getValue());
        classEntity.setCompiled(jstat_class.get(5).getValue());
        classEntity.setFailed(jstat_class.get(6).getValue());
        classEntity.setInvalid(jstat_class.get(7).getValue());
        classEntity.setTime2(jstat_class.get(8).getValue());
        classRepository.save(classEntity);
    }
    public void clearAll() {
        classRepository.deleteAll();
    }
}
