/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.threads;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author lv250077
 */
public class CyclicBarrierExample {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        final Thread t1 = new Thread(new CabService(cyclicBarrier));
        t1.setName("One");
        t1.start();

        final Thread t4 = new Thread(new CabService(cyclicBarrier));
        t4.setName("Four");
        t4.start();

        final Thread t2 = new Thread(new CabService(cyclicBarrier));
        t2.setName("Two");
        t2.start();

        final Thread t3 = new Thread(new CabService(cyclicBarrier));
        t3.setName("Three");
        t3.start();

        final Thread t5 = new Thread(new CabService(cyclicBarrier));
        t5.setName("Five");
        t5.start();
    }

}
