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
public class CrunchifyBlockingConsumer implements Runnable {

    private final BlockingQueue<CrunchifyMessage> queue;

    public CrunchifyBlockingConsumer(final BlockingQueue<CrunchifyMessage> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            CrunchifyMessage msg;
            // consuming messages until exit message is received
            while ((msg = queue.take()).getMsg() != "exit") {
                Thread.sleep(10);
                System.out.println("CrunchifyBlockingConsumer: Message - " + msg.getMsg() + " consumed.");
            }
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

}
