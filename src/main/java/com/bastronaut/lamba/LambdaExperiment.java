package com.bastronaut.lamba;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

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

    public static void forEachPredicateFunctionExperiment(List<Person> personnel, Predicate<Person> tester) {
        personnel.forEach((p) -> tester.test(p));
    }

    public static void forEachConsumerExperiment(List<Person> personnel) {
        personnel.forEach((p)-> System.out.println(p));
    }

    public static void forEachConsumerExperimentTwo(List<Person> personnel, Consumer<Person> accepter) {
        personnel.forEach(accepter);
    }


    public static void embeddedConsumer(List<Person> personnel, Consumer<List<Person>> printer) {
        printer.accept(personnel);
    }

    // too many params but experiment to check all the functional interfaces
    public static void functionPredicateConsumer(List<Person> personnel, Function<Person, String> mapper, Predicate<Person> tester, Consumer<Person> accepter) {
        personnel.forEach((p) -> {
            String name = mapper.apply(p);
            if (tester.test(p)) {
                accepter.accept(p);
                System.out.println("method was tested for: ".concat(name));
            }
        });
    }

    // functional interfaces with generics - unreadable but ya
    public static <X, Y> void genericsFuncInterfaces(Iterable<X> source, Function<X, Y> mapper,
                                                    Predicate<X> predicate, Consumer<Y> consumer) {
        for (X x : source) {
            Y mapped = mapper.apply(x);
            if (predicate.test(x)) {
                consumer.accept(mapped);
            }
        }
    }

    // stream functions.
    public static void aggregateExperiment(List<Person> source) {
        source.stream()
                .filter(p -> p.getAge() > 10)
                .map(p -> p.getName())
                .skip(1)
                .limit(2)
                .forEach(name -> System.out.println(name));
    }

    public static void aggregateStreamExperiment(Stream<Person> stream) {
        stream.filter(p -> p.getAge() > 10)
                .map(p -> p.getName())
                .skip(1)
                .limit(2)
                .forEach(name -> System.out.println(name));
    }
}
