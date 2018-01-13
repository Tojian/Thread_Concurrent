package com.concurrent.threadpool.scheduledthreadpool;

import java.util.Date;

/**
 * Created by taojian on 2018/1/13 0013  下午 7:15.
 */
public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println("name " + command + " Start. Time = "+new Date());
        processCommand();
        System.out.println("name " + command + " End. Time = "+new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
