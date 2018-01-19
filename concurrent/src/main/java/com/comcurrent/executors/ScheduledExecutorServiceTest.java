
package com.comcurrent.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: taojian
 * @time : 18:47 2018/1/18
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println("1111111111111111111111@@@@@@@@@@@");
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("===============");
            }
        }, 3, TimeUnit.SECONDS);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@2222222222222222");
        scheduledExecutorService.shutdown();
    }
}
