package com.bastronaut.lamba;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by Bas on 20-3-2017.
 */
public class LambdaTest {

    ArrayList<Person> personnel;

    @Before
    public void setup() {
        ArrayList<Person> personnel = new ArrayList<Person>();
        Person hanks = new Person(80);
        Person tom = new Person(34);
        personnel.add(hanks);
        personnel.add(tom);
        this.personnel = personnel;
    }


    @Test
    public void testPrintOldPeople() {
        LambdaExperiment.printOldPeople(personnel, new PersonSuitableForWheelchairTester());
    }

    //naive implementation still without lambda with an anonymous class instead of a seperate class
    @Test
    public void testPrintOldPeopleAnonymousClass() {
        LambdaExperiment.printOldPeople(personnel, new IPersonTester() {
            @Override
            public boolean test(Person p) {
                return p.getAge() > 65;
            }
        });
    }
}