package com.simplethread.join;

/**
 * Created by taojian on 2018/1/25 0025  下午 10:13.
 */
public class JoinThread extends  Thread {
    public JoinThread(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println(this.getName() + ":" + i);
        }
    }
}
