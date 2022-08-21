package com.xinrg.JavaMonitor.timer.socket;

import com.xinrg.JavaMonitor.model.ClassEntity;
import com.xinrg.JavaMonitor.model.GcEntity;
import com.xinrg.JavaMonitor.model.ThreadEntity;
import com.xinrg.JavaMonitor.service.ClassService;
import com.xinrg.JavaMonitor.service.GcService;
import com.xinrg.JavaMonitor.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SendController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ClassService classService;
    @Autowired
    private GcService gcService;
    @Autowired
    private ThreadService threadService;
    @MessageMapping("/gc")
    @SendTo("/topic/gc")
    public List<GcEntity> socketGc(String pid) {
        return gcService.findAllByPid(pid);
    }
    @MessageMapping("/cl")
    @SendTo("/topic/cl")
    public List<ClassEntity> socketClass(String pid) {
        return classService.findAllByPid(pid);
    }
    @MessageMapping("/thread")
    @SendTo("/topic/thread")
    public List<ThreadEntity> socketThread(String pid) {
        return threadService.findAllByPid(pid);
    }
}
