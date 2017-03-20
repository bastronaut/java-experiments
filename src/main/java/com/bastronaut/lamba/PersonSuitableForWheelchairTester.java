package com.bastronaut.lamba;

/**
 * Created by Bas on 20-3-2017.
 */
public class PersonSuitableForWheelchairTester implements IPersonTester {

    @Override
    public boolean test(Person p) {
        return p.getAge() > 65;
    }

}
