package com.bastronaut.optional;

/**
 * Created by Bas on 1-4-2017.
 */
public class Graphicscard {

    String version;

    public Graphicscard(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void updateGraphicscard() {
        this.version = "3.0";
    }
}
