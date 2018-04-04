/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author lv250077
 */
public class DateTimeAPITest {
    /**
     * Constant to convert time from milliseconds to minutes.
     */
    private static final int CONVERT_TIME_TO_MINUTES = 60000;

    public static void main(final String[] args) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //System.out.println(LocalDateTime.now().format(formatter));
        final Map<String, String> hm = new HashMap<>();
        hm.put("1", LocalDateTime.now().toString());
        hm.put("2", LocalDateTime.now().format(formatter).toString());
        hm.put(
                "3",
                LocalDateTime
                        .now()
                        .plusMinutes(Long.parseLong("180000") / CONVERT_TIME_TO_MINUTES)
                        .format(formatter));

        final long diffInSeconds = java.time.Duration
                .between(LocalDateTime.now(), LocalDateTime.parse(hm.get("3"), formatter))
                .getSeconds();
        System.out.println(diffInSeconds);
        System.out.println(hm);
        testVector();
        testArrayList();

    }

    public static void testArrayList() {
        final long startTime = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }
        final long endTime = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println("Test ArrayList: " + totalTime + " ms");
    }

    public static void testVector() {
        final long startTime = System.currentTimeMillis();
        final Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10_000_000; i++) {
            vector.addElement(i);
        }
        final long endTime = System.currentTimeMillis();
        final long totalTime = endTime - startTime;
        System.out.println("Test Vector: " + totalTime + " ms");
    }

}
