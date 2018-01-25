package com.concurrent.condition;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by taojian on 2018/1/25 0025  下午 11:12.
 */
public class Product implements Runnable {

    BlockingQueue blockingQueue =new ArrayBlockingQueue(5);
    @Override
    public void run() {
    synchronized(this){
        while(true){
            blockingQueue.add(new Object());
            if (blockingQueue.size()==5){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }
}
