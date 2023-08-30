package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

public class BJ2485 {
    public String solve(String input) {

        // parse into int array
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        int[] trees = new int[s.length - 1];
        for (int i = 1; i < n + 1; i++) {
            trees[i - 1] = Integer.parseInt(s[i]);
        }

        // record difference in order into array

        // find min(diff)

        // find gcd of all diff

        // divide each diff with gcd and minus 1 and return sum
        return null;

    }
}
