package com.bastronaut.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by BSijtsma on 16-05-2017.
 */
public class Pairs {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] line_split = line.split(" ");

        int size = Integer.parseInt(line_split[0]);
        int k = Integer.parseInt(line_split[1]);

        int[] numbers = new int[size];

        String line2 = in.nextLine();
        String[] line2_split = line2.split(" ");

        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(line2_split[i]);
        }
        pairs(numbers, k);
    }

    public static int pairs(int[] numbers, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) {
            map.put(i, i);
        }

        map.entrySet().stream()
                .filter((e) -> (map.get(k - e.getKey()) != null ));
//                .reduce();

        return 1;
    }
}

