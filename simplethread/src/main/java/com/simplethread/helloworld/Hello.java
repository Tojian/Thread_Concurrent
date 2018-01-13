package com.simplethread.helloworld;

/**
 * Created by taojian on 2018/1/12 0012  下午 11:02.
 */
public class Hello extends Thread {

    private  String name;

    public Hello(String name) {
        this.name = name ;
    }

    public void run(){
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("thread number is " + i + "thread name :" + name );
        }
    }
}
