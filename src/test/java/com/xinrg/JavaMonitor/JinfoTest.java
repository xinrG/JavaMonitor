package com.xinrg.JavaMonitor;

import com.xinrg.JavaMonitor.core.ExecuteCmd;
import com.xinrg.JavaMonitor.entity.JinfoEntity;
import com.xinrg.JavaMonitor.order.Jinfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JinfoTest {
    @Test
    public void testExecuteCmd() {
        String s = ExecuteCmd.execute(new String[] {"jstat","-class","15232"});
        System.out.println(s);
    }
    @Test
    public void test() {
        JinfoEntity jinfoEntity = Jinfo.info("15232");
        List<String> str1 = jinfoEntity.getNonDefault();
        List<String> str2 = jinfoEntity.getCommandLine();
        System.out.println("nonDefault");
        for(String s:str1) {
            System.out.println(s);
        }
        System.out.println("commandLine");
        for(String s:str2) {
            System.out.println(s);
        }
    }
}
