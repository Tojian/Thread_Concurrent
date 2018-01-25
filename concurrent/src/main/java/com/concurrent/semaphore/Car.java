package com.concurrent.semaphore;

/**
 * Created by taojian on 2018/1/25 0025  下午 10:47.
 */
public class Car extends Thread{
    private Driver driver;

    public Car(Driver driver) {
        super();
        this.driver = driver;
    }

    public void run() {
        driver.driveCar();
    }
}
