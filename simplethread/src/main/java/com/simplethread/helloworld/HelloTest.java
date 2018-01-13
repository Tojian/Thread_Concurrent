package com.simplethread.helloworld;

/**
 * Created by taojian on 2018/1/12 0012  下午 11:05.
 */
public class HelloTest {

    public static void main(String[] args) {
        //---------------Thread--------------------//
        Hello hello = new Hello("A");
        Hello hello1 = new Hello("B");
        hello.start();
        hello1.start();

        //----------------Runnable-----------------------//
        new Thread(new HelloRun("C")).start();
        new Thread(new HelloRun("D")).start();
    }
}
