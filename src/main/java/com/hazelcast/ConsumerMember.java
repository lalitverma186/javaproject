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
public class ConsumerMember {
    public static void main(final String[] args) throws Exception {
        final Config config = new Config();
        final QueueConfig queueConfig = config.getQueueConfig("default");
        queueConfig
                .setName("queue")
                .setBackupCount(1)
                .setMaxSize(5)
                .setStatisticsEnabled(true);
        config.addQueueConfig(queueConfig);
        final HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
        final IQueue<String> queue = hz.getQueue("queue");
        while (true) {
            final String item = queue.take();
            System.out.println("Consumed: " + item);
            if (item.isEmpty()) {
                queue.put("BLANK");
                break;
            }
            Thread.sleep(10000);
        }
        System.out.println("Consumer Finished!");
    }
}
