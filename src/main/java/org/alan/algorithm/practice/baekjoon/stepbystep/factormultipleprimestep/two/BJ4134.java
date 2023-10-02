package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

public class BJ4134 {
    public String solve1(String input) {
        // parse
        long n = Long.parseLong(input);

        if (n == 0 || n == 1 || n == 2) {
            return "2";
        }

        long i = 0;
        while (i < n) { // while i + n < 2n (since from n to 2n there is at least one prime number), do not let infinite loop.
            long dividend = i + n;
            double root = Math.sqrt(dividend);

            long m = 0;
            for (long divisor = 2; divisor <= root; divisor++) {
                if (dividend % divisor == 0) {
                    break;
                }
                m++;
            }

            // if dividend has never been divided complete with divisor from 2 to root of dividend
            if (m == root - 1) {
                return String.valueOf(dividend);
            }

            i++;
        }

        return "0";
    }

    public String solve2(String n) {
        long number = Long.parseLong(n);

        if (number == 0 || number == 1 || number == 2) {
            return "2";
        }

        while (true) {
            int result = 0;
            for (long j = 2; j <= Math.sqrt((double) number); j++) {
                if (number % j == 0) {
                    result++;
                    break;
                }
            }

            if (result == 0) {
                return String.valueOf(number);
            }

            number++;
        }
    }
}
