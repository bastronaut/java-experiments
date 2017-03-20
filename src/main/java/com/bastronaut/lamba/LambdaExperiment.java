package com.bastronaut.lamba;

import java.util.List;

/**
 * Created by Bas on 20-3-2017.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * The use case:
 * Suppose that you are creating a social networking application. You want to create a feature that enables an
 * administrator to perform any kind of action, such as sending a message, on members of the social networking
 * application that satisfy certain criteria. The following table describes this use case in detail:
 *
 */
public class LambdaExperiment {


    public static void printOldPeople(List<Person> persons, IPersonTester tester) {

        for (Person p : persons) {
           if (tester.test(p)) {
               System.out.println(p.toString());
           }
        }
    }





}
