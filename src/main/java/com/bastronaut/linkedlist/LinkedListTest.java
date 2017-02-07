package com.bastronaut.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 07-02-2017.
 */
public class LinkedListTest {

    @Test
    public void pop() throws Exception {
        LinkedList<String> ll = new LinkedList<>();
        ll.push("Hi");
        assertTrue(ll.pop().equals("Hi"));
        ll.push("1");
        ll.push("2");
        ll.push("3");
        assertTrue(ll.pop().equals("3"));
        assertTrue(ll.getSize() == (2));
        assertTrue(ll.pop().equals("2"));
        assertFalse(ll.isEmpty());
        assertTrue(ll.pop().equals("1"));
        assertTrue(ll.getSize() == (0));
        assertTrue(ll.isEmpty());
    }

}