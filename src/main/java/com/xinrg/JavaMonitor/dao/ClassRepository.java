package com.xinrg.JavaMonitor.dao;

import com.xinrg.JavaMonitor.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Integer> {
    List<ClassEntity> findAllByPid(String pid);
}
