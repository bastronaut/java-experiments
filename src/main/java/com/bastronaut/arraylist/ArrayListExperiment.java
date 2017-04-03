package com.bastronaut.arraylist;

import java.util.ArrayList;

/**
 * Created by BSijtsma on 03-04-2017.
 *
 */
public class ArrayListExperiment {

    private static void testRemoveIndex() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(list.toString()); // [1, 2, 1, 3]
        list.remove(1); // [1, 1, 3]
        System.out.println(list.toString());
    }

    private static void testRemoveObject() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.toString()); // [1, 1, 2, 3, 4]
        list.remove("1"); // [1, 2, 3, 4]
        list.remove("1"); // [2, 3, 4]
        list.remove("1"); // [2, 3, 4]
        list.remove("1"); // [2, 3, 4]
        System.out.println(list.toString());
    }


    public static void main(String[] args) {
//        testRemoveIndex();
//        testRemoveObject();
    }





}
