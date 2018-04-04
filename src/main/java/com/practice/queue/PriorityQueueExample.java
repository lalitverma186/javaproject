/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.practice.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author lv250077
 */
public class PriorityQueueExample {

    public static void main(final String[] args) {
        final PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");
        System.out.println("head1:" + queue.element());
        System.out.println("head2:" + queue.peek());
        System.out.println("iterating the queue elements:");
        final Iterator itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        queue.remove();
        queue.poll();
        System.out.println("after removing two elements:");
        final Iterator<String> itr2 = queue.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }

}
