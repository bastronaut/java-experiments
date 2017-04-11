package com.bastronaut.various;

import com.bastronaut.accessmodifiers.MemberModifiers;

/**
 * Created by Bas on 11-4-2017.
 */
public class MemberModifiersSubclass extends MemberModifiers {

    public static void main(String[] args) {
        MemberModifiersSubclass mm = new MemberModifiersSubclass();
        System.out.println(mm.public_i); // allowed
        System.out.println(mm.protected_i); // ALLOWED FROM PARENT CLASS
//        System.out.println(mm.nomodifier_i); // NOT allowed
//        System.out.println(mm.private_i); // NOT allowed


        // protected is allowed to access from parent class. BUT! Only if instantiated from
        // its own class. This is not allowed:
        MemberModifiers mmParent = new MemberModifiers();
//        System.out.println(mmTwo.protected_i); -> Compile error, cannot access from parent

    }

}
