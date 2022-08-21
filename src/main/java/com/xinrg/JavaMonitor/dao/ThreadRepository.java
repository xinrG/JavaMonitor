package com.xinrg.JavaMonitor.dao;

import com.xinrg.JavaMonitor.model.ThreadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ThreadRepository extends JpaRepository<ThreadEntity,Integer> {
    List<ThreadEntity> findAllByPid(String pid);
}
