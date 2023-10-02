package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep.two;

public class BJ17103 {
    private final byte[] net = new byte[1000000];

    public String solve(String input) {
        int i = Integer.parseInt(input);

        int a, b, count = 0;
        for (a = 2; a <= i / 2; a++) {
            b = i - a;
            if (isPrime(a) && isPrime(b)) {
                count++;
            }
        }
        return String.valueOf(count);
    }

    private boolean isPrime(int i) {
        byte state = net[i + 1];
        if (state == 1) {
            return true;
        }
        else if (state == 2) {
            return false;
        }

        if (i <= 1) {
            return recordFalse(i);
        }

        if (i == 2) {
            return recordTrue(i);
        }

        for (int j = 2; j <= Math.sqrt(i); j++) {   // O(n ** 0.5)
            if (i % j == 0) {
                return recordFalse(i);
            }
        }
        return recordTrue(i);
    }

    private boolean recordFalse(int i) {
        net[i + 1] = 2;
        return false;
    }

    private boolean recordTrue(int i) {
        net[i + 1] = 1;
        return true;
    }
}
