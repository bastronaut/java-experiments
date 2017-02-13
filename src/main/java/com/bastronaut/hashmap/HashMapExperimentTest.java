package com.bastronaut.hashmap;

import com.bastronaut.linkedlist.LinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 01-02-2017.
 */
public class HashMapExperimentTest {

    HashMapExperiment<String, String> customMap = new HashMapExperiment<>();

    @Before
    public void setUp() throws Exception {
        HashMapExperiment<String, String> customMap = new HashMapExperiment<>();
        customMap.put("name", "bas");
        customMap.put("age", "henk");
        customMap.put("thing", "thang");
        customMap.put("yo", "lo");
        this.customMap = customMap;
    }

    // TODO TDD test still fails
    @Test
    public void hasKey() throws Exception {
        assertTrue(customMap.hasKey("name"));
        assertTrue(customMap.hasKey("color"));
        assertTrue(customMap.hasKey("thing"));
    }

    @Test
    public void put() {

    }

}