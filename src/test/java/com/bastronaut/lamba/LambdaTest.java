package com.bastronaut.lamba;

import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by Bas on 20-3-2017.
 */
public class LambdaTest {

    @Test
    public void testPrintOldPeople() {
        ArrayList<Person> personnel = new ArrayList<Person>();
        Person hanks = new Person(80);
        Person tom = new Person(34);
        personnel.add(hanks);
        personnel.add(tom);
        LambdaExperiment.printOldPeople(personnel, new PersonSuitableForWheelchairTester());
    }
}