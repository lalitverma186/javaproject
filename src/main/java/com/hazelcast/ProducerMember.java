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
public class ProducerMember {
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
        for (int k = 1; k < 25; k++) {
            if (k == 6) {
                queue.put("Lalit");
            } else {
                queue.put("Name: " + k);
            }
            System.out.println("Producing: " + k);
            Thread.sleep(2000);
        }
        queue.put("BLANK");
        System.out.println("Producer Finished!");
        //
        //
    }
}
