package com.bastronaut.lamba;

/**
 * Created by BSijtsma on 29-03-2017.
 * Test to check what errors happen when you try adding
 * more methods to a functional interface through
 * e.g. inheritance
 *
 * Not being able to add multiple methods makes sense:
 * when you implement an interface with a lambda,
 * you leave the other methods unimplemented. You would
 * deviate from the contract if not all methods are implemented
 */
public interface FuncImplExperiment extends IPersonTester {


    @Override
    boolean test(Person p);

    // adding another method with the same signature leads to:
    //  Multiple non-overriding abstract methods found in interface FuncImplExperiment...
//    public boolean testTwo(Person p);

    // Same for adding a function with a differetn method signature
//    public String what(int x);

    // No complaints when adding a default method to the interface.
    // Even when this method has the same signature
    // the implementation in FuncImplExperimentTest.java overrides the
    // test function above.
    default boolean testDefault(Person p) {
        System.out.println("default");
        return false;
    }

    // No complains when adding static methods either
    static boolean testSatatic(Person p) {
        System.out.println("static");
        return false;
    }


}
