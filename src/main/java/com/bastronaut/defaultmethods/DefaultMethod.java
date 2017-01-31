package com.bastronaut.defaultmethods;

/**
 * Created by BSijtsma on 30-01-2017.
 * Allows adding new functionality to interface without breaking the existing classes
 * implementing the interface.
 * Useful for the extention of collection interfaces, with e.g. functional
 * forEach method added without breaking backward compability
 */
public class DefaultMethod implements InterfaceTest, InterfaceTestTwo  {
    public void doSomething() {
        System.out.println("something");
    }

    @Override
    public void clashFunction() {
        InterfaceTestTwo.super.clashFunction();
        InterfaceTest.super.clashFunction();
    }
}

interface InterfaceTest {
    public void doSomething();

    // Default methods must be given an implementation in case the implementing classes
    // do not provide their own
    default void doesNotRequireImpl() {
        System.out.println("Yep");
    };

    default void clashFunction() {
        System.out.println("Test One");
    }
}

interface InterfaceTestTwo {
    default void clashFunction() {
        System.out.println("Test Two");
    };
}
