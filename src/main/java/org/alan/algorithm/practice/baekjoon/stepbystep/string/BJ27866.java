package org.alan.algorithm.practice.baekjoon.stepbystep.string;

public class BJ27866 {

    public char solve(String input) {
        String[] strings = input.split("\n");
        int i = Integer.parseInt(strings[1]);
        return strings[0].charAt(i - 1);
    }
}
