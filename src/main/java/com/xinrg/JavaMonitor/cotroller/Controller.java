package com.xinrg.JavaMonitor.cotroller;

import com.xinrg.JavaMonitor.entity.JpsEntity;
import com.xinrg.JavaMonitor.order.Jps;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/")
    public String index(Model model) {
        Map<String, JpsEntity> jps = Jps.jps();
        model.addAttribute("jps",jps);
        return "index";
    }
    @RequestMapping(value = "/main")
    public String main(Model model) {
        model.addAttribute("jps",Jps.jps());
        model.addAttribute("version","1.8.0_201");
        return "main";
    }
    @RequestMapping(value = "/monitor")
    public String monitor(Model model) {
        return "monitor";
    }
    @RequestMapping(value = "/test")
    public String test(Model model) {
        return "test";
    }
}
