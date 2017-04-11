package com.bastronaut.accessmodifiers;

/**
 * Created by Bas on 11-4-2017.
 * package private: no explicit modifier, or the default, makes it visible only within
 * its own package. This means any class inthe accessmodifiers package: even
 * classes in com.bastronaut can not access it
 */
class ProtectedClass {
    public static void main(String[] args) {
        System.out.println("protected class");
    }
}
