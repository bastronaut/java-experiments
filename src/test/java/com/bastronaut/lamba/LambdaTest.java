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
    // " This approach reduces the amount of code required because you don't have to create a new class
    // for each search that you want to perform. However, the syntax of anonymous classes is bulky considering
    // that the CheckPerson interface contains only one method. In this case, you can use a lambda expression
    // instead of an anonymous class, as described in the next section. "
    @Test
    public void testPrintOldPeopleAnonymousClass() {
        LambdaExperiment.printOldPeople(personnel, new IPersonTester() {
            @Override
            public boolean test(Person p) {
                return p.getAge() > 65;
            }
        });
    }


    // " The CheckPerson interface is a functional interface. A functional interface is any interface that contains
    // only one abstract method. (A functional interface may contain one or more default methods or static methods.)
    // Because a functional interface contains only one abstract method, you can omit the name of that method
    // when you implement it. To do this, instead of using an anonymous class expression, you use a lambda expression "
    @Test
    public void testPrintOldPeopleFunctionalInterface() {
        LambdaExperiment.printOldPeople(personnel, (Person p) -> p.getAge() > 65);
    }
}