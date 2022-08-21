package com.xinrg.JavaMonitor.timer.config;

import com.xinrg.JavaMonitor.timer.job.ClearJob;
import com.xinrg.JavaMonitor.timer.job.UpdateJob;
import com.xinrg.JavaMonitor.timer.util.CronPram;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartzConfig {
    private Logger logger = LoggerFactory.getLogger(QuartzConfig.class);
    @Autowired
    private CronPram cronPram;
    @Bean
    public JobDetail updateDetail() {
        return JobBuilder.newJob(UpdateJob.class).withIdentity("updateJob").storeDurably().build();
    }
    @Bean
    public Trigger updateTrigger() {
        logger.warn("monitor.rate: "+cronPram.getRate());
        return TriggerBuilder.newTrigger().forJob(updateDetail())
                .withIdentity("updateTrigger")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(cronPram.getRate())
                        .repeatForever()
                )
                .build();
    }
    @Bean
    public JobDetail clearDetail() {
        return JobBuilder.newJob(ClearJob.class).withIdentity("clearJob").storeDurably().build();
    }
    @Bean
    public Trigger clearTrigger() {
        logger.warn("monitor.corn: "+cronPram.getCron());
        return TriggerBuilder.newTrigger().forJob(clearDetail())
                .withIdentity("clearTrigger")
                .startNow()
                .withSchedule(
                        CronScheduleBuilder.cronSchedule(cronPram.getCron())
                )
                .build();
    }
}
