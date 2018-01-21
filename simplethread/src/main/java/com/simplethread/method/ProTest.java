package com.simplethread.method;

/**
 * Created by taojian on 2018/1/21 0021  下午 5:44.
 */
public class ProTest {
    public static void main(String[] args) {
        PriorityThread it1 = new PriorityThread();
        PriorityThread it2 = new PriorityThread();
        Thread proxy1 = new Thread(it1,"线程1");
        Thread proxy2 = new Thread(it2,"线程2");
        proxy1.setPriority(Thread.MAX_PRIORITY);//设置为最高优先级
        proxy2.setPriority(Thread.MIN_PRIORITY);//设置为最低优先级
        proxy1.start();
        proxy2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        it1.stop();
        it2.stop();
    }
}
