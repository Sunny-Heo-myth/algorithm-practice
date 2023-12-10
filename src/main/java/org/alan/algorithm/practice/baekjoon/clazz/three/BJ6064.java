package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.regex.Pattern;

public class BJ6064 {
    public String solve(String input) {
        int[] ints = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        if (ints[0] == ints[1]) {
            if (ints[2] == ints[3]) return String.valueOf(ints[2]);
            else return String.valueOf(-1);
        }

        int biggerBase;
        int smallerBase;
        int biggerDecimal;
        int smallerDecimal;
        if (ints[0] > ints[1]) {
            biggerBase = ints[0];
            smallerBase = ints[1];
            biggerDecimal = ints[2];
            smallerDecimal = ints[3];
        } else {
            smallerBase = ints[0];
            biggerBase = ints[1];
            smallerDecimal = ints[2];
            biggerDecimal = ints[3];
        }

        int lcm = biggerBase * smallerBase / euclidGcd(biggerBase, smallerBase);
        while (biggerDecimal != smallerDecimal && (biggerDecimal < lcm || smallerDecimal < lcm)) {
            if (biggerDecimal > smallerDecimal) {
                smallerDecimal += smallerBase;
            } else {
                biggerDecimal += biggerBase;
            }
        }

        if (biggerDecimal == smallerDecimal) return String.valueOf(smallerDecimal);
        else return String.valueOf(-1);
    }

    private int euclidGcd(int x, int y) {
        if (y == 0) return x;
        else return euclidGcd(y, x % y);
    }
}
