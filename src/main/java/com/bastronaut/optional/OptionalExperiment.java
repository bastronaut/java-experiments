package com.bastronaut.optional;

import java.util.Optional;


/**
 * Created by Bas on 31-3-2017.
 *
 * The problem:
 * imagine the scenario:
 * String graphicscardVersion = computer.getGraphicscard().getVersion();
 *
 * If either computer or getGraphicscard returns a null, we forgot the null check and will now
 * get a NPE. What we can do is use optionals
 *
 * Optional<T>:
 * A container object which may or may not contain a non-null value. If a value is present,
 * isPresent() will return true and get() will return the value.
 *
 * Returning an optional adds explicit possibility that there might not be something there
 */
public class OptionalExperiment {


    public static void optionalExperimentWithException() throws Exception {
        Computer computer = new Computer("intel");
        Optional<Graphicscard> maybeGraphicscard = computer.getGraphicscardException();
    }

    public static String optionalExperimentWithExceptionTwo() {
        Computer computer = new Computer("intel");

        Optional<Graphicscard> maybeGraphicscard = computer.getGraphicscardNullable();
        // will throw exception after the get()
        //  Graphicscard gc = maybeGraphicscard.get();
        return maybeGraphicscard.get().getVersion();
    }

    public static String optionalExperimentNullableIsNull() {
        Computer computer = new Computer("intel");

        Optional<Graphicscard> maybeGraphicscard = computer.getGraphicscardNullable();

        if (maybeGraphicscard.isPresent()) {
            Graphicscard gc = maybeGraphicscard.get();
            return gc.getVersion();
        } else {
            return ""; // would do special case, now its obvious it may be null
        }
    }


    public static String optionalExperimentNullableIsNotNull() {
        Computer computer = new Computer("intel");
        computer.installGraphicsCard();

        Optional<Graphicscard> maybeGraphicscard = computer.getGraphicscardNullable();

        if (maybeGraphicscard.isPresent()) {
            Graphicscard gc = maybeGraphicscard.get();
            return gc.getVersion();
        } else {
            return ""; // would do special case, now its obvious it may be null
        }
    }

    public static String optionalExperimentIfPresent() {
        Computer computer = new Computer("intel");
        computer.installGraphicsCard();

        Optional<Graphicscard> maybeGraphicscard = computer.getGraphicscardOptional();

        maybeGraphicscard.ifPresent(graphicscard -> graphicscard.updateGraphicscard());
        return maybeGraphicscard.get().getVersion();
    }







}
