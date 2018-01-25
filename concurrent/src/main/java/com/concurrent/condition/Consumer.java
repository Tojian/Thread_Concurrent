package com.concurrent.condition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by taojian on 2018/1/25 0025  下午 11:13.
 */
public class Consumer implements  Runnable {
    BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
     while (true){
         try {
             Object o = blockingQueue.take();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }
    }
}
