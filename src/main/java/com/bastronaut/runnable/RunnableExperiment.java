package com.bastronaut.runnable;

/**
 * Created by Bas on 28-3-2017.
 */
public class RunnableExperiment implements Runnable {

    String name;

    RunnableExperiment(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("name - " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]) {

        // interesting: race condition?
        RunnableExperiment uno = new RunnableExperiment("uno");
        new Thread(uno).start(); // expect: name - uno. but result is name - unouno
        uno.setName("unouno"); // unouno is set here
        uno.run(); // maybe a race condition?

        RunnableExperiment dos = new RunnableExperiment("dos");
        RunnableExperiment tres = new RunnableExperiment("tres");
        RunnableExperiment vier = new RunnableExperiment("vier");
        new Thread(dos).start();
        new Thread(tres).start();
        new Thread(vier).start();
    }

}

