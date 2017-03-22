package com.bastronaut.lamba;

import java.util.List;
import java.util.function.Predicate;

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

    // naive implementation without lambda
    public static void printOldPeople(List<Person> personnel, IPersonTester tester) {
        for (Person p : personnel) {
           if (tester.test(p)) {
               System.out.println(p.toString());
           }
        }
    }

    public static void printOldPeopleWithPredicate(List<Person> personnel, Predicate<Person> tester) {
      for (Person p: personnel) {
          if (tester.test(p)) {
              System.out.println(p);
          }
      }
    }

    public static void forEachConsumerExperiment(List<String> sentences) {
        sentences.forEach((s)-> System.out.println(s));
    }

    public static void predicateFunctionExperiment(List<String> sentences, Predicate<String> tester) {
        sentences.forEach((s) -> tester.test(s));
    }

}