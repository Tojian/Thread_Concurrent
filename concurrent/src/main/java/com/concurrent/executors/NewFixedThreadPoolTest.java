
package com.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: taojian
 * @time : 16:43 2018/1/18
 */
public class NewFixedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task = new Task("task");
        Thread task1 = new Thread(task);
        Thread task2 = new Thread(task);
        Thread task3 = new Thread(task);
        executorService.execute(task1);
        executorService.shutdown();
    }
    }

