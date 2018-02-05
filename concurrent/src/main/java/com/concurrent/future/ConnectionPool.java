/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */

package com.concurrent.future;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: taojian
 * @time : 20:35 2018/2/5
 */
public class ConnectionPool {
    private ConcurrentHashMap<String, Connection> pool = new ConcurrentHashMap<String, Connection>();

    public Connection getConnection(String key) {
        Connection conn = null;
        if (pool.containsKey(key)) {
            conn = pool.get(key);
        } else {
            conn = createConnection();
            pool.putIfAbsent(key, conn);
        }
        return conn;
    }

    public Connection createConnection() {
        return new Connection();
    }

    class Connection {}
}
