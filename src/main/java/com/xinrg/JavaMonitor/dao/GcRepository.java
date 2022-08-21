package com.xinrg.JavaMonitor.dao;

import com.xinrg.JavaMonitor.model.GcEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GcRepository extends JpaRepository<GcEntity,Integer> {
    List<GcEntity> findAllByPid(String pid);
}
