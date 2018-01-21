package com.simplethread.method;

/**
 * Created by taojian on 2018/1/21 0021  下午 5:45.
 */
public class Work implements Runnable{

    @Override
    public void run() {
        System.out.println("name is " + Thread.currentThread().getName() +"=======");
    }
}
