package com.bastronaut.various;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bas on 4-6-2017.
 */

interface Contract {}
class Super implements Contract{};
class Sub extends Super{};

public class PractiseExamNotes {

    public static void main(String[] args) {
        Contract c1 = new Super();
        Contract c2 = new Sub();
        Super s1 = new Sub();

        List objs = new ArrayList();
        objs.add(c1);
        objs.add(c2);
        objs.add(s1);

        for (Object itm: objs) {
            System.out.println(itm.getClass().getName());
        }

        legalVarNames();
    }

    public static void legalVarNames() {
        // legal $ character
        int $ocajp;
        int _hello;

//      // Illegal characters
//        int b.la;
//        int %asd;
//        int bla@bla
//        int new;
//        int $*bla;
//        int 2DPoint;
//        int 1bla;
    }

    public static void arrayCopyTest() {
        int[] arr = {1, 2, 3, 4, 5};
        System.arraycopy(arr, 1, arr, 2, 2);
    }

    public void ExceptionsNote() {
        /*
        unchecked exceptions are runtime exceptions. however, you can still
        catch them. its common to throw a RunTimeException when the user calls
        a method incorrectly. or a NullPointer exception at method call

        Here's the bottom line guideline: If a client can reasonably be
        expected to recover from an exception, make it a checked exception.
        If a client cannot do anything to recover from the exception, make
        it an unchecked exception.

         */
    }

    public void validSwitchTypes() {
//        String i = "a"; // compatible
//        int i = "a"; // compatible
        Integer i = 5; // compatible
//        float i = 5; // not allowed!!
//        double i = 1; // not allowed!!!

//        int i = 5;
        switch (i){
//            case "a": return;
            case 5: return;
        }
    }

    public void interfaceVa() {
        /*
        Q: interfaces allow calling methods , such as equals. does
        an interface then inherit from Object?
        A: No.
        An interface implicitly declared one method for each public
        method in Object. Thus the equals method is implicitly
        declared as a member in an interface (unless it already
        inherits it from a superinterface).
        https://stackoverflow.com/questions/6056124/do-interfaces-inherit-from-object-class-in-java
         */
    }

    public void ohNo() throws IOException {
         // INSERT CODE HERE
//        throw new java.io.IOException();
        System.out.println("yo");

     }

    public int howMany(boolean b, boolean... c){
        return c.length;
    }

    public void testHowmany() {
        howMany(true, new boolean[2]);
        boolean[] x = {true, true};
        howMany(true, x);

//        howMany(true, {true, true}); // not allowed
        howMany(true, true, true, true, true, true); // allowed
    }

    public void twodimarray() {
        // not required to specify size of columns
        int[][] arr = new int[3][];
        int[] arrx = {1, 2, 3};
        int[] arry = {1, 2, 3, 4};
        arr[0] = arrx;
        arr[1] = arry;
    }
}

interface hasTest {
    abstract int getTest();
}
abstract class hasTwo implements hasTest {
//    default void yolo();
    // abstract classes cannot contain default methods, those are only
    // allowed in interfaces
    abstract int getTestY();

}

