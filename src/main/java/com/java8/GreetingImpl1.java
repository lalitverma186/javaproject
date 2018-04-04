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
public class GreetingImpl1 implements Greeting {

    /**
     * {@inheritDoc} Required implementation.
     */
    public void perform() {
        System.out.println("Hello from GreetingImpl1 !!");
    }

}
