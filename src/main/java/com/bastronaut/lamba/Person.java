package com.bastronaut.lamba;

/**
 * Created by Bas on 20-3-2017.
 */
public class Person {
    int age;
    int length;
    String name;

    public Person(String name, int age) {
        this.name = name;
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
        return this.name + " " + String.valueOf(this.age);
    }
}