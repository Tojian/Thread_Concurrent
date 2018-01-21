package com.simplethread.method;

/**
 * Created by taojian on 2018/1/21 0021  下午 5:58.
 */
public class PriorityThread implements  Runnable{

    private boolean flag = true;

    private int num = 0;
    @Override
    public void run() {

        while (flag){
            System.out.println(Thread.currentThread().getName() + " " + num++ );
        }
    }

    public void stop(){
        this.flag = ! flag;
    }
}
