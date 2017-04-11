package com.bastronaut.accessmodifiers;

/**
 * Created by Bas on 11-4-2017.
 *
 * public class: visible to all classes everywhere.
 */
public class PublicClass {
    public static void main(String[] args) {
        System.out.println("public class");

        MemberModifiers mm = new MemberModifiers();
        System.out.println(mm.public_i); // allowed
        System.out.println(mm.protected_i); // allowed
        System.out.println(mm.nomodifier_i); // allowed
//        System.out.println(mm.private_i); // NOT allowed
    }
}
