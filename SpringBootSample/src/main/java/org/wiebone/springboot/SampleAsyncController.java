package org.wiebone.springboot;

import javax.annotation.Resource;
import javax.annotation.PostConstruct;

import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Controller;

@Controller
public class SampleAsyncController {
 
    @Resource(name="asyncTaskService")
    private AsyncTaskService asyncTaskService;
    
    @Resource(name="asyncConfig")
    private AsyncConfig asyncConfig;

    @PostConstruct
    public void init() {
    	try {
            if (asyncConfig.isSampleTaskExecute()) {
            	//asyncTaskService.taskThread("thread-01");
            	//asyncTaskService.taskThread("thread-02");
            	//asyncTaskService.taskThread("thread-03");
            } else {
                System.out.println("////////// THREAD 개수 초과");
            }
        } catch (TaskRejectedException e) {
            System.out.println("////////// THREAD ERROR");
            System.out.println("TaskRejectedException : 등록 개수 초과");
            System.out.println("////////// THREAD END");
        }
    }
}
