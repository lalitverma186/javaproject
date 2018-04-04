/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.java8.excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lv250077
 */
public class Unit1Excercise {

    public static void main(final String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("Lalit", "Verma", 30),
                new Person("Sumit", "Sharma", 20),
                new Person("Anil", "Gupta", 40),
                new Person("Charu", "Pal", 25),
                new Person("Amit", "Verma", 45));
        //sorting the data Fname
        Collections.sort(people, (o1, o2) -> o1.getFname().compareTo(o2.getFname()));
        //Method to print all elements
        for (final Person p : people) {
            System.out.println("-------" + p);
        }

        //method to print all people whose name start with A
        final List Alist = new ArrayList<>();
        for (final Person p : people) {
            if (p.getFname().startsWith("A")) {
                Alist.add(p.getFname());
            }
        }
        System.out.println(Alist.size());

    }
}
