package org.wiebone.springboot;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    	
	private static int TASK_CORE_POOL_SIZE = 2;
	private static int TASK_MAX_POOL_SIZE = 5;
	private static int TASK_QUEUE_CAPACITY = 0;	
	private static String EXECUTOR_BEAN_NAME = "threadPoolTaskExecutor";

	@Resource(name="threadPoolTaskExecutor")
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Bean(name="threadPoolTaskExecutor")
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(TASK_CORE_POOL_SIZE);
       	executor.setMaxPoolSize(TASK_MAX_POOL_SIZE);
        executor.setQueueCapacity(TASK_QUEUE_CAPACITY);
        executor.setBeanName(EXECUTOR_BEAN_NAME);
        executor.initialize();
        return executor;
	}
	
	@Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
    }
	
    public boolean isSampleTaskExecute() {
        boolean rtn = true;
        System.out.println("EXECUTOR_SAMPLE.getActiveCount() : " + threadPoolTaskExecutor.getActiveCount());
        if (threadPoolTaskExecutor.getActiveCount() >= (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)) {
            rtn = false;
        } 
        return rtn;
    }

    public boolean isSampleTaskExecute(int createCnt) {
        boolean rtn = true;
        if ((threadPoolTaskExecutor.getActiveCount() + createCnt) > (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)) {
            rtn = false;
        }
        return rtn;
    }
}






	
	
