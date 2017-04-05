package com.bastronaut.various;

/**
 * Created by BSijtsma on 05-04-2017.
 */
public class StringExperiment {

    public static void testString() {
        String x = "bgglow_mid.jpg";
        String[]  xsplit = x.split("\\.");  // double escaping arg
        for (String s: xsplit) {
            System.out.println(s);
        };
    }

    public static void main(String[] args) {
        testString();
    }
}
