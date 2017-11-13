package com.bastronaut.lamba;

import java.util.stream.Stream;

/**
 * Created by BSijtsma on 13-11-2017.
 */
public class LambdaNullExperiment {

  public void testNullLambdas() {
    MaybeNull[] maybes = new MaybeNull[5];
    for (int i = 0; i < 5; i++) {
      MaybeNull maybe;
      if ((i+1) % 2 == 0) {
        maybe = new MaybeNull(true);
      } else {
        maybe = new MaybeNull(false);
      }
      maybes[i] = maybe;
    }

    String[] tested = Stream.of(maybes).filter(s -> s != null).map(s -> s.getMaybe()).toArray(String[]::new);

  }


  private class MaybeNull {
    String maybe;

    public MaybeNull(boolean flag) {
      if (flag) this.maybe = "param is set";
    }

    public String getMaybe() {
      return this.maybe;
    }
  }
}
