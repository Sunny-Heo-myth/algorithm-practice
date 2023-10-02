package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

public class BJ13909 {

    public String solve2(String input) {
        int n = Integer.parseInt(input);
        return String.valueOf((int) Math.floor(Math.sqrt(n)));
    }

    public String solve(String input) {
        // parse
        int n = Integer.parseInt(input);

        // simulate switching each window
        int answer = 0;
        for (int i = 0; i < n; i++) {   // O(NlgN)
            if (countFactor(i + 1) % 2 != 0) {
                answer++;
            }
        }

        return String.valueOf(answer);
    }

    private int countFactor(int n) {
        if (n < 2) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int count = 2;
        for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) { // O(lgN)
            int quotient = n / divisor;
            int remainder = n % divisor;

            if (remainder == 0) {
                if (quotient != divisor) {
                    count += 2;
                } else {
                    count++;
                }
            }
        }

        return count;
    }
}
