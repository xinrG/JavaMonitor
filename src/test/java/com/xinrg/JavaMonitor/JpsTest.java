package com.xinrg.JavaMonitor;

import com.xinrg.JavaMonitor.entity.JpsEntity;
import com.xinrg.JavaMonitor.entity.JstackEntity;
import com.xinrg.JavaMonitor.order.Jps;
import com.xinrg.JavaMonitor.order.Jstack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpsTest {
    @Test
    public void JstackTest() {
        JstackEntity jstackEntity = Jstack.jstack("15232");
        System.out.println(jstackEntity.getTotal());
        System.out.println(jstackEntity.getRUNNABLE());
        System.out.println(jstackEntity.getTIMED_WAITING());
    }
    @Test
    public void JpsTest() {
        Map<String, JpsEntity> map = Jps.jps();
        Iterator<Map.Entry<String,JpsEntity>> iterator =  map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, JpsEntity> entry = iterator.next();
            System.out.println(entry.getKey());
            JpsEntity jpsEntity = entry.getValue();
            System.out.println(jpsEntity.getClassName());
            System.out.println(jpsEntity.getSmallName());
            for (String s : jpsEntity.getParams()) {
                System.out.println(s);
            }
        }
    }
}
