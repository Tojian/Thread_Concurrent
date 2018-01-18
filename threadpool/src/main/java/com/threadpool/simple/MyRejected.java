/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */

package com.threadpool.simple;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: taojian
 * @time : 16:00 2018/1/18
 */
public class MyRejected  implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("自定义处理");
        System.out.println(r.toString());
        System.out.println(executor.getQueue().size());

    }
}
