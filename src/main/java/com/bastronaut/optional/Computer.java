package com.bastronaut.optional;

import java.util.Optional;

/**
 * Created by Bas on 1-4-2017.
 */
public class Computer {

    String version;
    Graphicscard graphicscard;

    public Computer(String version) {
        this.version = version;
    }

    void installGraphicsCard() {
        if (this.version.equals("intel")) {
            this.graphicscard = new Graphicscard("1.0");
        } else {
            this.graphicscard = new Graphicscard("2.0");
        }
    }

    // If executed with null, will throw a NoSuchElementException on the .get() of the Optional
    public Optional<Graphicscard> getGraphicscardNullable() {
        return Optional.ofNullable(graphicscard);
    }

    // You cannot add Null to an optional created with Optional.of. Will throw
    // a NullPOinterException directly
    public Optional<Graphicscard> getGraphicscardException() {
        Graphicscard newCard = null;
        return Optional.of(newCard);
    }

    public Optional<Graphicscard> getGraphicscardOptional() {
        if (this.graphicscard == null) {
            installGraphicsCard();
        }
        return Optional.of(graphicscard);
    }






}
