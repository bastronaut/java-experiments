package com.bastronaut.arraylist;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by BSijtsma on 04-04-2017.
 */
public class CustomArrayListTest {

    CustomArrayList<String> list = new CustomArrayList<>();

    @Before
    public void setUp() {
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
    }

    @Test
    public void testGet() {
        assertTrue(list.get(3).equals("three"));
        assertTrue(list.get(0).equals("zero"));
        assertTrue(list.get(4).equals("four"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        assertTrue(list.get(2) != null);
        list.get(20);
    }

    @Test
    public void testRemove() {
        assertTrue(list.remove(0).equals("zero"));
        assertTrue(list.remove(0).equals("one"));
        assertTrue(list.remove(2).equals("four"));
        assertTrue(list.remove(3).equals("six"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        list.remove(20);
    }

    @Test
    public void testHasValue() {
        assertTrue(list.hasValue("zero"));
        assertTrue(list.hasValue("one"));
        assertTrue(list.hasValue("two"));
        assertTrue(list.hasValue("three"));
        assertTrue(list.hasValue("four"));
        assertTrue(list.hasValue("five"));
        assertTrue(list.hasValue("six"));
        assertTrue(list.hasValue("seven"));
    }

    @Test
    public void testDoesNotHaveValue() {
        assertFalse(list.hasValue("eight"));
        assertFalse(list.hasValue("nine"));
        assertFalse(list.hasValue(""));
        assertFalse(list.hasValue("ablabla"));
        assertFalse(list.hasValue("oneone"));
    }

    // depends on functionalit of tests:
    // testHasValue()
    // testDoesNotHaveValue()
    @Test
    public void testAdd() {
        assertFalse(list.hasValue("hi"));
        assertTrue(list.add("hi"));
        assertTrue(list.hasValue("hi"));
    }

    @Test
    public void testSize() {
        assertTrue(list.size() == 8);
        assertTrue(list.size() == 8);
        list.add("eight");
        assertTrue(list.size() == 9);
        list.add("nine");
        assertTrue(list.size() == 10);
        list.remove(0);
        assertTrue(list.size() == 9);
        list.remove(0);
        list.remove(0);
        assertTrue(list.size() == 7);
        for (int i = 0; i < 7; i++) {
            list.remove(0);
        }
        assertTrue(list.size() == 0);
    }

    @Test
    public void testIndexOf() {
        assertTrue(list.indexOf("one") == 1);
        assertTrue(list.indexOf("seven") == 7);
    }

    @Test
    public void testIterator() {
        int i = 0;
        for (Object s : list) {
            i++;
        }
        assertTrue(i == 8);
    }

    @Test
    public void testIteratorTwo() {
        int i = 0;
        Iterator listIterator = list.iterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            i++;
        }
        assertTrue(i == 8);
    }

    @Test
    public void testForEach() {
        list.forEach((o) -> System.out.println(o));
    }
}