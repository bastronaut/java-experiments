package com.bastronaut.various;

/**
 * Created by BSijtsma on 03-04-2017.
 */
public class RideableImpl implements Rideable {
    int weight = 2;

//  Cannot leave out the access modifier as by default it will be local, and you can only
//  increase the access level of an interface, not decrease it
//    String getGait() { return " mph, lope";}
    public String getGait() { return " mph, lope";}

    void go(int speed) {
        ++speed; ++weight;
        int walkrate = speed*weight;
        System.out.println(walkrate + getGait());
    }

    public static void main(String[] args) {
        new RideableImpl().go(8);
    }
}
