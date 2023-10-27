package cn.jiyun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class TimeSpring {


    @Scheduled(cron = "0/300 * * * * ?")
    public void tine() {

    }
}
