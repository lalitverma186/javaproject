/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.QueueConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

/**
 *
 * @author lv250077
 */
public class HazelCastTest {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        final Config config = new Config();
        final QueueConfig queueConfig = config.getQueueConfig("default");
        queueConfig
                .setName("MyQueue")
                .setBackupCount(1)
                .setMaxSize(5)
                .setStatisticsEnabled(true);
        config.addQueueConfig(queueConfig);
        final HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
        hz.getConfig().addQueueConfig(queueConfig);
        final IQueue<String> queue = hz.getQueue("MyQueue");
        System.out.println("Producer Finished!");
        for (int k = 1; k < 100; k++) {
            queue.put("name:: " + k);
            System.out.println("Producing: " + k);
            Thread.sleep(1000);
        }
        final String item = queue.take();
        if (!item.isEmpty()) {
            System.out.println("Consumed: " + item);
        }
        System.out.println("Producer Finished!");
    }
}
