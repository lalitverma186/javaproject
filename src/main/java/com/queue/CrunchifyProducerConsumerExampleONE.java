/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.queue;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author lv250077
 */
public class CrunchifyProducerConsumerExampleONE {

    public static class Consumer extends Thread {
        @SuppressWarnings("rawtypes")
        @Override
        public void run() {
            for (;;) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Object Consumed ################");
                } catch (final Exception e) {
                    e.printStackTrace();
                }

                synchronized (data) {
                    final Iterator it = data.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            }
        }
    }

    public static class Producer extends Thread {
        Producer() {
            super("Producer");
        }

        @Override
        public void run() {
            for (;;) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Object Produced ~~~~~~~~~~~~~~~");
                } catch (final Exception e) {
                    e.printStackTrace();
                }
                data.add(new Object());
                if (data.size() > 1000) {
                    data.remove(data.size() - 1);
                }
            }
        }
    }

    private static Vector<Object> data = new Vector<>();

    public static void main(final String[] args) {
        new Producer().start();
        new Consumer().start();
    }

}
