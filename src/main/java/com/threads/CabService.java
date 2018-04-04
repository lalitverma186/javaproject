/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author lv250077
 */
public class CabService implements Runnable {
    private final CyclicBarrier cb;

    public CabService(final CyclicBarrier c) {
        cb = c;
    }

    @Override
    public void run() {
        try {
            System.out.println("I am doing work ad not stopped.");
            cb.await();
            System.out.println("I have been stopped and waiting to other theards....");
        } catch (final InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
