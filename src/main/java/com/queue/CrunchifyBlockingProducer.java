/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.queue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author lv250077
 */
public class CrunchifyBlockingProducer implements Runnable {
    private final BlockingQueue<CrunchifyMessage> crunchQueue;

    public CrunchifyBlockingProducer(final BlockingQueue<CrunchifyMessage> queue) {
        crunchQueue = queue;
    }

    @Override
    public void run() {
        // producing CrunchifyMessage messages
        for (int i = 1; i <= 5; i++) {
            final CrunchifyMessage msg = new CrunchifyMessage("i'm msg " + i);
            try {
                Thread.sleep(10);
                crunchQueue.put(msg);
                System.out.println("CrunchifyBlockingProducer: Message - " + msg.getMsg() + " produced.");
            } catch (final Exception e) {
                System.out.println("Exception:" + e);
            }
        }

        // adding exit message
        final CrunchifyMessage msg = new CrunchifyMessage("All done from Producer side. Produced 5 CrunchifyMessages");
        try {
            crunchQueue.put(msg);
            System.out.println("CrunchifyBlockingProducer: Exit Message - " + msg.getMsg());
        } catch (final Exception e) {
            System.out.println("Exception:" + e);
        }
    }
}
