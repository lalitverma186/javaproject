/*
 *-----------------------------------------------------------------------------
  * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.threads;

import java.util.concurrent.CountDownLatch;

/**
 * IMPORTANT ::::: run as configuration and with arguments as Pizza, Pasta, GarlicBread
 * 
 * @author lv250077
 */
public class CountdownLatchExample {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final CountDownLatch cdl = new CountDownLatch(3);
        final Thread foodprocessorThread = new Thread(new FoodProcessor(cdl, args));
        foodprocessorThread.start();
        try {
            System.out.println("Order is preparing..");
            cdl.await();
            System.out.println("Order is prepared... and ready to dispatch..");
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
