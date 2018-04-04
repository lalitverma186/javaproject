/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.hazelcast;

import java.util.HashMap;

/**
 *
 * @author lv250077
 */
public class TestHashmap {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(null, 1);
        hm.put(null, 2);
        hm.put(null, null);
        System.out.println(hm);
    }

}
