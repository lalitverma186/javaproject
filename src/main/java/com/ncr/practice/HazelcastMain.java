/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.ncr.practice;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author lv250077
 */
public class HazelcastMain {
    public static void main(final String[] args) {
        final HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        final IMap<String, String> employees = hz.getMap("employees");
        if (employees.containsKey("1")) {
            employees.put("6", "emp6");

        } else {
            employees.put("1", "emp1");
        }
        employees.put("2", "emp2");
        employees.put("3", "emp3");
        employees.put("4", "emp4");
        employees.put("5", "emp5");

        System.out.println("Total number of employees " + employees.size());
    }
}
