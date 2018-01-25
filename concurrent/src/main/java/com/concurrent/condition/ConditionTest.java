package com.concurrent.condition;

/**
 * Condition的作用是对锁进行更精确的控制。
 * Condition中的await()方法相当于Object的wait()方法，
 * Condition中的signal()方法相当于Object的notify()方法，
 * Condition中的signalAll()相当于Object的notifyAll()方法。
 * 不同的是，Object中的wait(),notify(),notifyAll()方法是和"同步锁"(synchronized关键字)捆绑使用的；
 * 而Condition是需要与"互斥锁"/"共享锁"捆绑使用的。
 * Created by taojian on 2018/1/25 0025  下午 11:02.
 */
public class ConditionTest {
}
