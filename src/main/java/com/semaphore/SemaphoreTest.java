/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author lv250077
 */
public class SemaphoreTest {
    static class MyATMThread extends Thread {
        String name = "";

        MyATMThread(final String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " : acquiring lock...");
                System.out.println(
                        name
                                + " : available Semaphore permits now: "
                                + semaphore.availablePermits());
                semaphore.acquire();
                System.out.println(name + " : got the permit!");
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(
                                name
                                        + " : is performing operation "
                                        + i
                                        + ", available Semaphore permits : "
                                        + semaphore.availablePermits());
                        // sleep 1 second
                        Thread.sleep(1000);
                    }
                } finally {
                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(
                            name
                                    + " : available Semaphore permits now: "
                                    + semaphore.availablePermits());
                }
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // max 4 people
    static Semaphore semaphore = new Semaphore(4);

    public static void main(final String[] args) {
        System.out.println(
                "Total available Semaphore permits : "
                        + semaphore.availablePermits());
        final MyATMThread t1 = new MyATMThread("A");
        t1.start();
        final MyATMThread t2 = new MyATMThread("B");
        t2.start();
        final MyATMThread t3 = new MyATMThread("C");
        t3.start();
        final MyATMThread t4 = new MyATMThread("D");
        t4.start();
        final MyATMThread t5 = new MyATMThread("E");
        t5.start();
        final MyATMThread t6 = new MyATMThread("F");
        t6.start();
    }
}
