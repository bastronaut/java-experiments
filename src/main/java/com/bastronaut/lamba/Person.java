package com.bastronaut.lamba;

/**
 * Created by Bas on 20-3-2017.
 */
public class Person {
    int age;
    int length;
    String name;

    public Person(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) { 
        this.length = length;
    }

    public String toString() {
        return String.valueOf(this.age);
    }
}