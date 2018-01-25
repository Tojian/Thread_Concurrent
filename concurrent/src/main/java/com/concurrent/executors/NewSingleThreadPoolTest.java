
package com.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: taojian
 * @time : 17:20 2018/1/18
 */
public class NewSingleThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Pakages pakages = new Pakages();
        executorService.execute(pakages);
        executorService.shutdown();
    }
}
