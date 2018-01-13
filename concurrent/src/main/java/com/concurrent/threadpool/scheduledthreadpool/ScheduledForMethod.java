package com.concurrent.threadpool.scheduledthreadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by taojian on 2018/1/13 0013  下午 9:32.
 */
public class ScheduledForMethod {

    public static void main(String[] args) {
        System.out.println(timeDelayed());
    }

    public static boolean timeDelayed(){

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                print();
            }
        } , 5, TimeUnit.SECONDS);
        return true;
    }
    public static void print(){
        System.out.println("=========begin==============");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=========end================");

    }
}
