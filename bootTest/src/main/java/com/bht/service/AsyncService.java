package com.bht.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("asyncService")
public class AsyncService {
    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);


    @Async("testExecutor")
    public void testTaskExecutor(int i) {
        logger.info("taskExecutor.execute" + i);
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("testExecutor")
    public void testTaskExecutor2(int i) {
        logger.info("taskExecutor.execute" + i);
    }

}
