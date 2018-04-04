/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.practice.queue;

/**
 *
 * @author lv250077
 */
public class bike extends vehicle {

    public static void main(final String[] args) {
        final bike b = new bike();
        b.car();
        b.car(1);
    }

    public void car(final int i) {
        System.out.println("car is here in bike!");
    }
}
