package com.bastronaut.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 07-02-2017.
 */
public class LinkedListTest {

    LinkedList<String, String> ll = new LinkedList<>();
    String yo = "" ;

    @Before
    public void setUp() throws Exception {
        ll.push("name", "bas");
        ll.push("age", "henk");
        ll.push("thing", "thang");
        ll.push("yo", "lo");
        this.ll = ll;
    }

    @Test
    public void search() throws Exception {
        System.out.println(yo);
        assertTrue(ll.search("name").equals("bas"));
        assertTrue(ll.search("x") == null);
        assertTrue(ll.search("yo").equals("lo"));
        assertTrue(ll.search("thing").equals("thang"));
        assertTrue(ll.search("age").equals("henk"));
        assertFalse(ll.search("age").equals("henkx"));
        assertFalse(ll.search("name").equals("thang"));
    }

    @Test
    public void pop() {

    }

    @Test
    public void push() {
        assertTrue(ll.search("name").equals("bas"));
        ll.push("name", "yolo");
        assertTrue(ll.search("name").equals("yolo"));
        ll.push("name", "yolox");
        assertTrue(ll.search("name").equals("yolox"));
        assertFalse(ll.search("name").equals("yolo"));
        assertFalse(ll.search("name").equals("bas"));
    }
}