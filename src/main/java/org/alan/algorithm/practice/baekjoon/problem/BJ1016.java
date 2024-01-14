package org.alan.algorithm.practice.baekjoon.problem;

public class BJ1016 {
    public String solve(String input) {
        String[] s = input.split(" ");
        long min = Long.parseLong(s[0]);
        long max = Long.parseLong(s[1]);
        int difference = (int) (max - min); // <= 1000000

        // make an eratos net with length of min - max + 1;
        boolean[] eratos = new boolean[difference + 1];

        // for each sqrt, check eratos with each multiple of square
        for (long sqrt = 2; sqrt * sqrt <= max; sqrt++) {
            long square = sqrt * sqrt;

            // find a first square in the range and check representing element
            long n = min % square == 0 ? min : (min / square + 1) * square;
            while (n <= max) {
                // index of an array allow only int. casting should only be happened for the index.
                eratos[(int) (n - min)] = true;
                n += square;
            }
        }

        int count = 0;
        for (boolean n : eratos) if (!n) count++;
        return String.valueOf(count);

    }

}
