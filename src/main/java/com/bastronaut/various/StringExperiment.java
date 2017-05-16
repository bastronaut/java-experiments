package com.bastronaut.various;

/**
 * Created by BSijtsma on 05-04-2017.
 */
public class StringExperiment {
    static int i = 5;

    public static void testString() {
        String x = "bgglow_mid.jpg";

        String[]  xsplit = x.split("\\.");  // double escaping arg
        for (String s: xsplit) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        testString();
        i = i + 5;
        System.out.println(i);
        System.out.println(128 >> 1);
        System.out.println("john".equals("john"));
        Boolean flag = true;
        boolean fslag = true;
    }
}
