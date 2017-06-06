package com.bastronaut.hackerrank;

import java.util.Scanner;

/**
 * Created by BSijtsma on 22-05-2017.
 * https://www.hackerrank.com/challenges/counting-valleys
 * easy easy
 *
 *
 */
public class Steps {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        String steps = in.next();
        int level = 0;
        int valleys = 0;
        boolean isvalley = false;

        for (int i = 0; i < n; i++) {
            char step = steps.charAt(i);
            if (step == 'U') {
                level++;
            }
            if (step == 'D') {
                level--;
            }
            if (level == 0) {
                isvalley = false;
            }
            if (level == -1 && isvalley == false) {
                isvalley = true;
                valleys++;
            }

        }


    }
}