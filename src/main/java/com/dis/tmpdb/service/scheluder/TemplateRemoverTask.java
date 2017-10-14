package com.dis.tmpdb.service.scheluder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class TemplateRemoverTask {

    //    @Scheduled(fixedDelay = 6000)
    public void sheludedMethod() {
        log.info("The time now is {}", LocalDateTime.now());
    }
}
