package com.concurrent.threadpool.scheduledthreadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by taojian on 2018/1/13 0013  下午 7:17.
 */
public class ScheduledThreadPool {


    public static void main(String[] args) throws InterruptedException {

      //  ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        System.out.println("Current Time = "+new Date());

        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        },5,TimeUnit.SECONDS);
        System.out.println("finish Time = "+new Date());

       /* ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        //schedule to run after sometime
        System.out.println("Current Time = "+new Date());
        for(int i=0; i<3; i++){
            Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("do heavy processing :" + i + " ");
            scheduledThreadPool.schedule(worker, 5, TimeUnit.SECONDS);
        }

        //add some delay to let some threads spawn by scheduler
        Thread.sleep(30000);

        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Finished all threads");
    }
*/
    }
}
