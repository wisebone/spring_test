package org.wiebone.springboot;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Service("asyncTaskService")
public class AsyncTaskService {
    
	@Resource(name="threadPoolTaskExecutor")
	ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	@Async("threadPoolTaskExecutor")
    public void taskThread(String str) {
		int poolSize = 0;
		String threadName = "";
		
        while (true) {
            poolSize = threadPoolTaskExecutor.getPoolSize();
            threadName = Thread.currentThread().getName();
             
            System.out.println("[" + str + "] " + "[총 스레드 개수:" + poolSize + "] 작업 스레드 이름: " + threadName);
        	
        	try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }
}