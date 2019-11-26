package com.bht.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class TaskExecutorConfig {
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorConfig.class);

    @Value("${taskExecutor.test.corePoolSize}")
    private int testCorePoolSize;
    @Value("${taskExecutor.test.keepAliveSeconds}")
    private int testKeepAliveSeconds;
    @Value("${taskExecutor.test.maxPoolSize}")
    private int testMaxPoolSize;
    @Value("${taskExecutor.test.queueCapacity}")
    private int testQueueCapacity;
    @Value("${taskExecutor.test.rejectedExecutionHandler}")
    private String testRejectedExecutionHandler;
    @Value("${taskExecutor.test.threadNamePrefix}")
    private String testThreadNamePrefix;

    private RejectedExecutionHandler getRejectedExecutionHandler(String rejectedExecutionHandlerStr) {
        RejectedExecutionHandler rejectedExecutionHandler = null;
        try {
            Class<?> aClass = Class.forName("java.util.concurrent.ThreadPoolExecutor$" + testRejectedExecutionHandler);
            Constructor<?> constructor = aClass.getConstructor();
            rejectedExecutionHandler = (RejectedExecutionHandler) constructor.newInstance();
        } catch (Exception e) {
            logger.error("初始化线程池拒绝策略失败", e);
        }
        return rejectedExecutionHandler;
    }

    @Bean(name = "testExecutor")
    public Executor testExecutor() {
        RejectedExecutionHandler rejectedExecutionHandler = getRejectedExecutionHandler(testRejectedExecutionHandler);
        if (rejectedExecutionHandler == null) {
            rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        }
        return getExecutor(testCorePoolSize, testKeepAliveSeconds, testMaxPoolSize, testQueueCapacity, rejectedExecutionHandler, testThreadNamePrefix);
    }


    private Executor getExecutor(int corePoolSize, int keepAliveSeconds, int maxPoolSize, int queueCapacity, RejectedExecutionHandler rejectedExecutionHandler, String threadNamePrefix) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        executor.setRejectedExecutionHandler(rejectedExecutionHandler);
        //执行初始化
        executor.initialize();
        return executor;
    }

}
