package com.bastronaut.lamba;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Created by Bas on 20-3-2017.
 * more of a function runner to experiment with lambdas, not that many test cases
 */
public class LambdaExperimentTest {

    ArrayList<Person> personnel;

    @Before
    public void setup() {
        ArrayList<Person> personnel = new ArrayList<Person>();
        Person hanks = new Person("hanks" , 80);
        Person tom = new Person("tom", 34);
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

    // The IPersonTester functional interface is useful yet so basic, that a built in standard functional interface
    // can be used: Predicate <T>  in java.util.function. It contains only: boolean test(T t).
    @Test
    public void testPrintOldPeopleWithPredicate() {
        LambdaExperiment.printOldPeople(personnel, p -> p.getAge() > 0 );
    }

    @Test
    public void testForEachPredicateFunctionExperiment() {
        LambdaExperiment.forEachPredicateFunctionExperiment(personnel, (Person p) -> p.getAge() > 65);
    }

    @Test
    public void testForEachConsumerExperiment() {
        LambdaExperiment.forEachConsumerExperiment(personnel);
    }

    @Test
    public void testforEachConsumerExperimentTwo() {
        LambdaExperiment.forEachConsumerExperimentTwo(personnel, p -> System.out.println(p));
    }

    @Test
    public void testforEachConsumerExperimentTwoImpl() {
        LambdaExperiment.forEachConsumerExperimentTwo(personnel, new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        });
    }

    @Test
    public void testEmbeddedConsumer() {
        LambdaExperiment.embeddedConsumer(personnel, new Consumer<List<Person>>() {

            @Override
            public void accept(List<Person> persons) {
                for (Person p : persons) {
                    System.out.println(p.getAge());
                }
            }
        });
    }

    
    @Test
    public void testConsumerFunctionApply() {
        LambdaExperiment.functionPredicateConsumer(personnel,
                new Function<Person, String>() {
                    @Override
                    public String apply(Person p) {
                        return p.getName();
                    }
                },
                new Predicate<Person>() {
                    @Override
                    public boolean test(Person p) {
                        return p.getAge() > 50;
                    }
                }
                ,
                new Consumer<Person>() {
                    @Override
                    public void accept(Person p) {
                        System.out.println(p);
                    }
                });
    }

    // same as function above but with lambda expressions
    @Test
    public void testConsumerFunctionApplyLambdas() {
        LambdaExperiment.functionPredicateConsumer(personnel,
                p -> p.getName(),
                p -> p.getAge() > 50,
                p -> System.out.println(p));
    }

    // print only the Person objects that are over 50
    @Test
    public void testGenericsFuncInterfaces() {
        LambdaExperiment.genericsFuncInterfaces(personnel,
                p -> p.getName(),
                p -> p.getAge() > 50,
                s -> System.out.println(s)
                );
    }
}