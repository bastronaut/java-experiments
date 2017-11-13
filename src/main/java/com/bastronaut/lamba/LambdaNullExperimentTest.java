package com.bastronaut.lamba;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by BSijtsma on 13-11-2017.
 */
public class LambdaNullExperimentTest {

  @Test
  public void testLambdaNull() {
    LambdaNullExperiment l = new LambdaNullExperiment();
    l.testNullLambdas();
  }
}