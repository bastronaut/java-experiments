package com.bastronaut.async;

/**
 * Created by Bas on 23-1-2017.
 */
public class AsyncTest {

    @org.junit.Test
    public void doSyncGet() throws Exception {
        Async.doSyncGet();
    }

    @org.junit.Test
    public void doAsyncGet() throws Exception {
        Async.doAsyncGet();
    }

}