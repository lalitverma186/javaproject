/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.java8.excercise;

/**
 *
 * @author lv250077
 */
public class Person {
    private int age;

    private String Fname;

    private String Lname;

    /**
     * Initializes an instance of <code>Person</code> with the default data.
     *
     * @param fname
     * @param lname
     * @param age
     */
    public Person(final String fname, final String lname, final int age) {
        super();
        Fname = fname;
        Lname = lname;
        this.age = age;
    }

    /**
     * Retrieves the value for {@link #age}.
     *
     * @return the current value
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves the value for {@link #fname}.
     *
     * @return the current value
     */
    public String getFname() {
        return Fname;
    }

    /**
     * Retrieves the value for {@link #lname}.
     *
     * @return the current value
     */
    public String getLname() {
        return Lname;
    }

    /**
     * Provides a value for {@link #age}.
     *
     * @param age the new value to set
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * Provides a value for {@link #fname}.
     *
     * @param fname the new value to set
     */
    public void setFname(final String fname) {
        Fname = fname;
    }

    /**
     * Provides a value for {@link #lname}.
     *
     * @param lname the new value to set
     */
    public void setLname(final String lname) {
        Lname = lname;
    }

    /**
     * {@inheritDoc} Required implementation.
     */
    @Override
    public String toString() {
        return "Person [Fname=" + Fname + ", Lname=" + Lname + ", age=" + age + "]";
    }

}
