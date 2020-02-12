package com.leverx.myapp.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class ScheduledTask {

    private static final int RATE_IN_MILLIS = 30000;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = RATE_IN_MILLIS)
    public void reportCurrentTime() {
        log.info("Current time {}", simpleDateFormat.format(new Date()));
    }
}
