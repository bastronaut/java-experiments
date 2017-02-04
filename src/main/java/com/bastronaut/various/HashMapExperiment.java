package com.bastronaut.various;


import java.util.HashMap;

/**
 * Created by BSijtsma on 01-02-2017.
 *
 * Experiment with recreating a HashMap data structure
 */
public class HashMapExperiment {

    public static void hashMapToString() {
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("name", "bas");
        testMap.put("surname", "henk");
        testMap.put("color", "Blue");
        System.out.println(testMap.toString());
    }


}
