package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime.two;

import java.util.Arrays;

public class BJ2485 {
    public String solve(String input) {

        // parse into int array
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        if (n < 3) {
            throw new IllegalArgumentException();
        }

        int[] trees = new int[s.length - 1];
        for (int i = 1; i < n + 1; i++) {
            trees[i - 1] = Integer.parseInt(s[i]);
        }

        // record difference in order into array
        int[] diffs = new int[s.length - 2];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = trees[i + 1] - trees[i];
        }

        // find min(diff)
        int min = Arrays.stream(diffs).min().orElseThrow(IllegalArgumentException::new);

        // find gcd of all diff
        int gcd = getGcd(diffs);

        // divide each diff with gcd and minus 1 and return sum
        return String.valueOf(Arrays.stream(diffs).map(i -> i/gcd - 1).sum());

    }

    // the correct time complexity is hard to represent with bounds (1000000000)
    private int getGcd(int[] diffs) {
        // sort array
        Arrays.sort(diffs); // O(nlogn)

        // find min
        int min = diffs[0];

        // divide each and all diff from min to 2
        for (int divisor = min; divisor >= 2; divisor--) {
            int i = 0;
            while (i < diffs.length) {
                int diff = diffs[i];
                if (diff % divisor != 0) {
                    break;
                }
                i++;
            }

            // if all diff is divided
            if (i == diffs.length) {
                return divisor;
            }
        }

        return 1;
    }
}
