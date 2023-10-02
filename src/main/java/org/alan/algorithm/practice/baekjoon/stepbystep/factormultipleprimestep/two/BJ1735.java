package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

public class BJ1735 {
    public String solve(String input) {
        String[] s = input.split("\n");

        String[] first = s[0].split(" ");
        int child1 = Integer.parseInt(first[0]);
        int parent1 = Integer.parseInt(first[1]);
        // simplify 1
        int gcd1 = getGcd(child1, parent1);
        int effectiveChild1 = child1 / gcd1;
        int effectiveParent1 = parent1 / gcd1;

        String[] second = s[1].split(" ");
        int child2 = Integer.parseInt(second[0]);
        int parent2 = Integer.parseInt(second[1]);
        // simplify 2
        int gcd2 = getGcd(child2, parent2);
        int effectiveChild2 = child2 / gcd2;
        int effectiveParent2 = parent2 / gcd2;

        // get lcm
        int lcm = getLcm(effectiveParent1, effectiveParent2);

        // get multiple for each number
        int child1Multiple = lcm / effectiveParent1;
        int child2Multiple = lcm / effectiveParent2;

        // multiply each number and sum & return
        int child = effectiveChild1 * child1Multiple + effectiveChild2 * child2Multiple;
        
        // simplify
        int gcd = getGcd(child, lcm);
        return child / gcd + " " + lcm / gcd;
    }

    private int getLcm(int i, int j) {
        int big;
        int small;

        if (i == j) {
            return i;

        } else {
            if (i > j) {
                big = i;
                small = j;
            } else {
                small = i;
                big = j;
            }

            if (big % small == 0) {
                return big;
            }
        }

        int lcm = big * small;
        for (int divisor = small - 1; divisor >= 1; divisor--) {
            if (small % divisor == 0 && big % divisor == 0) {
                return lcm / divisor;
            }
        }
        return lcm;
    }

    private int getGcd(int i, int j) {
        int big;
        int small;

        if (i == j) {
            return i;

        } else {
            if (i > j) {
                big = i;
                small = j;
            } else {
                small = i;
                big = j;
            }

            if (big % small == 0) {
                return small;
            }
        }

        for (int divisor = small - 1; divisor >= 1; divisor--) {
            if (small % divisor == 0 && big % divisor == 0) {
                return divisor;
            }
        }
        return 1;
    }
}
