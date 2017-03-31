package com.bastronaut.optional;

import java.util.Optional;

/**
 * Created by Bas on 31-3-2017.
 *
 * As found on:
 * http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
 *
 * The problem:
 * String usbversion = computer.getSoundcard().getUSB().getVersion();
 * if computer, soundcard or usb returns null, we crash.
 *
 * Optional<T>:
 * A container object which may or may not contain a non-null value. If a value is present,
 * isPresent() will return true and get() will return the value.
 *
 *
 */
public class Computer {
    private Optional<Soundcard> Soundcard;
    private Optional<Soundcard> getSoundcard() { };

    // creating a new optional:
    Optional<Soundcard> sc = Optional.empty();

    // Optional with non-null value
    Soundcard soundcard = new Soundcard("v1");
    Optional<Soundcard> sctwo = Optional.of(soundcard);

    // Optional that may hold null value
    Optional<Soundcard> scthree = Optional.ofNullable(soundcard);

    public void testOptional() {
        // instead of having to do:
        if (soundcard != null) {
            System.out.println(soundcard);
        }
        // we no longer need explicit null check and can do:
        sctwo.ifPresent(System.out::println);
    }

    public void testOptionalOrElse() {
        // but thats not recommened. Normally, ternary operation:
        Soundcard maybeSoundcard = new Soundcard("v1");
        // set with ternary operation
        Soundcard soundcard = maybeSoundcard != null ? maybeSoundcard : new Soundcard("basic sound card");
        // can be rewritten using an optional:
        Soundcard soundcardtwo = sctwo.orElse(new Soundcard("v1"));

        //alternatively with orElseThrow()
        Soundcard soundcardthree = sctwo.orElseThrow(IllegalStateException::new);
    }

}
