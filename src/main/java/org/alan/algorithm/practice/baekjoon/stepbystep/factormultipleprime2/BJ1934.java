package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

public class BJ1934 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] ss = s[i + 1].split(" ");
            ints[i] = new int[]{Integer.parseInt(ss[0]), Integer.parseInt(ss[1])};
        }

        StringBuilder sb = new StringBuilder();

        for (int[] line : ints) {
            int i = line[0]; int j = line[1];

            int big;
            int small;

            if (i == j) {
                sb.append(j).append("\n");
                continue;

            } else {
                if (i > j) {
                    big = i;
                    small = j;
                } else {
                    small = i;
                    big = j;
                }

                if (big % small == 0) {
                    sb.append(big).append("\n");
                    continue;
                }
            }

            for (int divisor = small - 1; divisor >= 1; divisor--) { // todo: performance by dividing 2
                if (small % divisor == 0 && big % divisor == 0) {
                    sb.append(((long) big * small) / divisor).append("\n");
                    break;
                }
            }
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
        // check if one of the is 1, if then return non 1.
        // check if both are same, if then return the number.

        // figure out which one is smaller.

        // declare gcd, lcm
        // if the smaller one is even, divide from half to 1
        // if the smaller one is odd, divide, from one-third to 1
        // if the smaller one is divided with current biggest factor divide the bigger one with the factor.
        // if the big one is divided, initiate gcd

        // multiply the big and the small and divide it with gcd, initiate lcm
        // return lcm
    }

    // check if one of the is 1, if then return non 1.
    // check if both are same, if then return the number.

    // figure out which the smaller one
    // declare ms, mb with init value small, big
    // multiply smaller one and saved it into ms

    // compare with the big
    // if it is same return big
    // if it is ms is smaller than mb
    // calculation is up to 45000 * 45000

}
