package com.simplethread.helloworld;

/**
 * Created by taojian on 2018/1/12 0012  下午 11:15.
 */
public class HelloRun implements Runnable {
    private String  name;

    public HelloRun(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 9 ;i++){
            System.out.println("thread number is " + i);
        }
    }
}
