package com.bastronaut.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 07-02-2017.
 */
public class LinkedListTest {

    LinkedList<String, String> ll = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        LinkedList<String, String> ll = new LinkedList<>();
        ll.push("name", "bas");
        ll.push("age", "henk");
        ll.push("thing", "thang");
        ll.push("yo", "lo");
        this.ll = ll;
    }

    @Test
    public void search() throws Exception {
        LinkedList<String, String> ll = new LinkedList<>();
        assertTrue(ll.search("name").equals("bas"));
        assertTrue(ll.search("x") == null);
        assertTrue(ll.search("yo").equals("lo"));
        assertTrue(ll.search("thing").equals("thang"));
        assertTrue(ll.search("age").equals("henk"));
    }

    @Test
    public void pop() {

    }
}