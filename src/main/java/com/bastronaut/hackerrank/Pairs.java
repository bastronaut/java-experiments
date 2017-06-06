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

//        System.out.println("calling pairs");
//        pairs(new int[]{1, 5, 3, 4, 2}, 2);


        System.out.println(0 / 3);
        System.out.println(1 / 3);
        System.out.println(2 / 3);
        System.out.println(3 / 3);
        System.out.println(4 / 3);
        System.out.println(5 / 3);
        System.out.println(6 / 3);
        System.out.println(7 / 3);
        System.out.println(8 / 3);
        System.out.println(9 / 3);
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

        int count = (int) map.entrySet().stream()
                .map(i -> i.getKey())
                .filter(i -> map.get(i - k) != null)
                .count();

        System.out.println(count);

        return count;
    }
}

