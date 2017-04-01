package com.bastronaut.optional;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Bas on 1-4-2017.
 */
public class OptionalExperimentTest {

    @Test(expected = NullPointerException.class)
    public void testOptionalExperimentWithException() throws Exception {
        OptionalExperiment.optionalExperimentWithException();
    }

    @Test(expected = NoSuchElementException.class)
    public void testOptionalExperimentWithExceptionTwo() throws Exception {
        OptionalExperiment.optionalExperimentWithExceptionTwo();
    }

    @Test
    public void testOptionalExperimentNullableIsNull() {
        String gcversion = OptionalExperiment.optionalExperimentNullableIsNull();
        assertTrue("Graphics card is null because Optional.ofNullable", gcversion.equals(""));
    }

    @Test
    public void testOptionalExperimentNullableIsNotNull() {
        String gcversion = OptionalExperiment.optionalExperimentNullableIsNotNull();
        assertTrue("Graphics card v 1.0 because Optional.of", gcversion.equals("1.0"));
    }

    @Test
    public void testOptionalExperimentIfPresent() {
        String gcversion = OptionalExperiment.optionalExperimentIfPresent();
        assertTrue("Graphics card v 3.0 because upgade was done", gcversion.equals("3.0"));
    }

}