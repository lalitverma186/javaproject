/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.queue.test;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author lv250077
 */
public class CrunchifyBlockingProducer implements Runnable {
    private final BlockingQueue<String> crunchQueue;

    public CrunchifyBlockingProducer(final BlockingQueue<String> queue) {
        crunchQueue = queue;
    }

    @Override
    public void run() {
        // producing CrunchifyMessage messages
        for (int i = 1; i <= 5; i++) {
            final String msg = new String("i'm msg " + i);
            try {
                Thread.sleep(10);
                crunchQueue.put(msg);
                System.out.println("CrunchifyBlockingProducer: Message - " + msg.toString() + " produced.");
            } catch (final Exception e) {
                System.out.println("Exception:" + e);
            }
        }

        // adding exit message
        final String msg = new String("All done from Producer side. Produced 5 CrunchifyMessages");
        try {
            crunchQueue.put(msg);
            System.out.println("CrunchifyBlockingProducer: Exit Message - " + msg.toString());
        } catch (final Exception e) {
            System.out.println("Exception:" + e);
        }
    }
}
