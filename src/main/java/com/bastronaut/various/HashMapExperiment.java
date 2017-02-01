package com.bastronaut.various;

import com.google.caliper.Param;
import com.google.caliper.SimpleBenchmark;
import java.util.HashMap;

/**
 * Created by BSijtsma on 01-02-2017.
 *
 * Experiment with hash collision when placing hashcodes in bins and its effect on performance
 * in a hashmap
 *
 * example from: http://www.nurkiewicz.com/2014/04/hashmap-performance-improvements-in.html
 * benchmark using google caliper
 */
public class HashMapExperiment extends SimpleBenchmark {

    public static void hashMapToString() {
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("name", "bas");
        testMap.put("surname", "henk");
        testMap.put("color", "Blue");
        System.out.println(testMap.toString());
    }

    @Benchmark
    public static void testHashMapGet() {

    }
}
