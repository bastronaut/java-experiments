package com.bastronaut.hashmap;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 01-02-2017.
 */
public class HashMapExperimentTest {
    @Test
    public void hashMapToString() throws Exception {
        HashMapExperiment.hashMapToString();

        HashMapExperiment<String, String> customMap = new HashMapExperiment<>();
        customMap.put("name", "bas");
        customMap.put("color", "blue");
        customMap.put("thing", "thang");

        assertSame("bas", customMap.get("name"));
    }

}