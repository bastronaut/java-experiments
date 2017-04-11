package com.bastronaut.various;

import com.bastronaut.accessmodifiers.MemberModifiers;

/**
 * Created by Bas on 11-4-2017.
 * Example how a class in another package, even if its also in the
 * com.bastronaut parent package, is not allowed to access the
 * package-private class ProtectedClass
 */
public class ProtectedClassTest {
    public static void main(String[] args) {
//        Compile error, not allowed
//        ProtectedClass pc = new ProtectedClass;
//        also a compile error
//        com.bastronaut.accessmodifiers.ProtectedClass pc2 = new com.bastronaut.accessmodifiers.ProtectedClass();


        MemberModifiers mm = new MemberModifiers();
        System.out.println(mm.public_i); // allowed
//        System.out.println(mm.protected_i); // NOT allowed outside of package
//        System.out.println(mm.nomodifier_i); // NOT allowed outside of package
//        System.out.println(mm.private_i); // NOT allowed outside of class

    }

}
