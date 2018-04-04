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
public class StringTypeInterface {

    interface StringLengthLambda {
        int getLength(String s);
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final StringLengthLambda stringLengthLambda = s -> s.length();
        System.out.println(stringLengthLambda.getLength("Lalit"));

        printLambda(s -> s.length());
    }

    public static void printLambda(final StringLengthLambda l) {
        System.out.println(l.getLength("Sumit Verma"));
    }
}
