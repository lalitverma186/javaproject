/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.stream;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author lv250077
 */
public class SequentialParallelComparison {

    public static void main(final String[] args) {
        final String[] strings = {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };

        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(strings).sequential());
        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(strings).parallel());
    }

    public static void run(final Stream<String> stream) {

        stream.forEach(s -> {
            System.out.println(
                    LocalTime.now()
                            + " - value: "
                            + s
                            +
                            " - thread: "
                            + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
