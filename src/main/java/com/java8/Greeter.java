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
public class Greeter {

    public static void main(final String[] args) {
        final Greeting greeterImpl = new GreetingImpl();
        greeterImpl.perform(); //One Way
        final Greeting lambdaGreeter = () -> System.out.println("Hi1111!!");
        lambdaGreeter.perform(); //Second Way
        Greeting greeterAnonymous = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hi !! from Anonymous!!!");                
            }
        };
        greeterAnonymous.perform(); //Third Way
        Greeter greeter = new Greeter();
        greeter.greet(() -> System.out.println("HI!! direct!!!"));
    }

    public void greet(final Greeting greeting) {
        greeting.perform();
    }

}
