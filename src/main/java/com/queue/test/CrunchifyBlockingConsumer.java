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
public class CrunchifyBlockingConsumer implements Runnable {

    private final BlockingQueue<String> queue;

    public CrunchifyBlockingConsumer(final BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String msg;
            // consuming messages until exit message is received
            while ((msg = queue.take()).toString() != null) {
                Thread.sleep(10);
                System.out.println("CrunchifyBlockingConsumer: Message - " + msg.toString() + " consumed.");
            }
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

}
