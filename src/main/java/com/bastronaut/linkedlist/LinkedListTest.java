package com.bastronaut.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 07-02-2017.
 */
public class LinkedListTest {

    @Test
    public void pop() throws Exception {
        LinkedList<String, String> ll = new LinkedList<>();
        ll.push("name", "bas");
        ll.push("age", "henk");
        ll.push("thing", "thang");
        ll.push("yo", "lo");
        assertTrue(ll.search("name").equals("bas"));
        assertTrue(ll.search("x") == null);
        assertTrue(ll.search("yo").equals("lo"));
        assertTrue(ll.search("thing").equals("thang"));
        assertTrue(ll.search("age").equals("henk"));

    }

}