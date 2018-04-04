/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.threads;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author lv250077
 */
public class FoodProcessor extends Thread {
    private final String[] items;

    private final CountDownLatch latch;

    public FoodProcessor(final CountDownLatch cdl, final String[] items) {
        latch = cdl;
        this.items = items;
    }

    @Override
    public void run() {
        for (int i = 0; i < items.length; i++) {
            System.out.println("Before Processing " + latch.getCount());
            try {
                Thread.sleep(5000);
                System.out.println("Item " + items[i] + " is prepared now.");
                latch.countDown();
                System.out.println("After Processing " + latch.getCount());
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
