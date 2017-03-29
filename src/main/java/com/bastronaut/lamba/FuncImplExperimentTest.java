package com.bastronaut.lamba;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 29-03-2017.
 */
public class FuncImplExperimentTest {

    ArrayList<Person> personnel;

    @Before
    public void setup() {
        ArrayList<Person> personnel = new ArrayList<Person>();
        Person hanks = new Person("hanks" , 80);
        Person tom = new Person("tom", 34);
        Person arnold = new Person("arnold", 17);
        Person schwarz = new Person("schwarz", 71);
        personnel.add(hanks);
        personnel.add(tom);
        personnel.add(arnold);
        personnel.add(schwarz);
        this.personnel = personnel;
    }

    @Test
    public void testMultipleFunctionsFunctionalInterface() {
        FuncImplExperiment i = (p) -> p.getAge() > 20;
        personnel.forEach(p -> {
            System.out.println(p.getName() + ":" + i.test(p));
        });
    }
}