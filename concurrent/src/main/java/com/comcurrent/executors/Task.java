
package com.comcurrent.executors;

/**
 * @Description:
 * @Author: taojian
 * @time : 16:38 2018/1/18
 */
public class Task implements Runnable {
    int i = 1;
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
        /*指代的为 t,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized(this) {
            /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                try {
            /*使其休眠100毫秒，放大线程差异*/
                    //Thread,currentThread().sleep(0,100);使其休眠100纳秒
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (i <= 100) {

                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                    /*放弃资源，等待*/
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
