/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */

package com.threadpool.simple;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: taojian
 * @time : 15:58 2018/1/18
 */
public class SimpleThreadPoolTest {
    /**
     * corePoolSize：
     * 核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，
     * 默认情况下，线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，
     * 除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，从这2个方法的名字就可以看出，
     * 是预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。默认情况下，在创建了线程池后，
     * 线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
     *
     * maximumPoolSize：
     * 线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；
     *
     * keepAliveTime：
     * 表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime
     * 才会起作用，直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，如果一个线程空闲的时间达到keepAliveTime
     * ，则会终止，直到线程池中的线程数不超过corePoolSize。但是如果调用了allowCoreThreadTimeOut(boolean)方法，
     * 在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；
     *
     * unit：
     * 参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, 												// 核心的线程数量
                2, 											// 最大的线程数量
                10, 											// 空闲数值
                TimeUnit.SECONDS, 								// 空闲时间单位
                new ArrayBlockingQueue<Runnable>(3),
                //	new LinkedBlockingQueue<Runnable>()
                new MyRejected()
        ); 			// 队列容器


        Task t1 = new Task(1, "任务" + 1);
        Task t2 = new Task(2, "任务" + 2);
        Task t3 = new Task(3, "任务" + 3);
        Task t4 = new Task(4, "任务" + 4);
        Task t5 = new Task(5, "任务" + 5);
        // Task t1 = new Task(1, "任务" + 1);
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pool.getQueue().size());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pool.getQueue().size());
        pool.shutdown();
    }
}

