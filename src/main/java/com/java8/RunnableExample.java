/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.java8;

/**
 *
 * @author lv250077
 */
public class RunnableExample {

    public static void main(final String[] args) {
        final Thread myThread = new Thread(() -> System.out.println("Printed inside Runnable!!!"));
        myThread.run();
    }

}
