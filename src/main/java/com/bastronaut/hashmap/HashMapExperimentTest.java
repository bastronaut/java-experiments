package com.bastronaut.hashmap;

import com.bastronaut.linkedlist.LinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

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

    @Test
    public void testOriginal() {
        HashMap<String, String> hm = new HashMap<>();
        hm.remove("bob");
        hm.put("yo", "henk");
        hm.remove("yolo");
    }

   @Test
   public void testPut() {
       String mapString = customMap.toString();
       System.out.println(mapString);
       assertTrue(mapString.contains("name: bas"));
       assertTrue(mapString.contains("age: henk"));
       assertTrue(mapString.contains("thing: thang"));
       assertTrue(mapString.contains("yo: lo"));
       assertFalse(mapString.contains("yo: x"));
   }

    @Test
    public void testRemove() {
        String mapString = customMap.toString();
        System.out.println(mapString);
        assertTrue(mapString.contains("name: bas"));
        customMap.remove("name");
        System.out.println(customMap);
    }

    @Test
    public void testHasKey() {
        assertTrue(customMap.hasKey("name"));
        assertFalse(customMap.hasKey("color"));
        assertTrue(customMap.hasKey("thing"));
    }

    @Test
    public void testGet() {
        assertTrue(customMap.get("name").equals("bas"));
        assertTrue(customMap.get("age").equals("henk"));
        assertTrue(customMap.get("yo").equals("lo"));
        assertTrue(customMap.get("xxx") == null);
        assertTrue(customMap.get("thing").equals("thang"));
        assertTrue(customMap.get("thing").equals("thang"));
    }

    @Test
    public void testPutMany() {
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
        customMap.put("ha", "hi");
//        assertTrue(customMap.size() == 5);
        HashMap<String, String> hm = new HashMap<>();

    }

    // TODO: make hashmap accept constructor with initial size and load factor
    // TODO: build hashmap resizer
}