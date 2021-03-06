package com.bastronaut.classcasting;

/**
 * Created by BSijtsma on 03-04-2017.
 */
public class Gamma extends Beta {

    String echo() {
        return "gamma";
    }

    String gammaFunction() {
        return "gamma specific";
    }

    public static void main(String[] args) {
//      Gamma a = new Beta(); // not allowed to instantiate parent class
//      casting ofcourse only from subclass to parent class
//        Gamma b = new Beta(); // not allowed, subclass from superclass
//        Gamma g = (Gamma) new Beta(); // not allowed but not compiler error, is runtime exception

        Beta bg = new Gamma();  // allowed, superclass from subclass
//      Beta b = new Alpha(); // not allowed, subclass from superclass

        Alpha a = new Beta();

        Alpha aa = new Gamma();
        System.out.println("aa : " + aa.echo());

        Beta c = new Gamma(); // allowed, superclass from subclass
        Beta b = (Beta) new Gamma(); // allowed, superclass from subclass
        b.betaFunction(); // supertype function ofcourse allowed
//      b.gammaFunction() // does not compile, function is lost in typecast to superclass

        System.out.println("a: "+ a.echo()); // prints: beta, remains a Beta() object but is treated as Alpha
        System.out.println("b: "+ b.echo());
        System.out.println("c: "+ c.echo());

        Gamma gg = new Gamma();
        Beta bb = (Beta) gg;
        System.out.println(bb.echo());

        // Here we force a class cast by first creating the superclass
        // Compiler will not catch this, wil; be an exception at runtime
        Beta bbb = new Beta();
//        Gamma ggg = (Gamma) bbb;
//        System.out.println(ggg.echo());

    }

}
