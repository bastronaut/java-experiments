package com.bastronaut.fileio;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Bas on 28-3-2017.
 */
public class FileIO {
    public static void main(String[] args) {
        Path p1 = Paths.get("in\\new");
        Path p2 = Paths.get("file.txt");
        System.out.println(p1.resolve(p2));
    }





}
