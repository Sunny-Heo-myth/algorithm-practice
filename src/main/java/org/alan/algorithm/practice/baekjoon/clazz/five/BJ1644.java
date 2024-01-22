package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.stream.IntStream;

public class BJ1644 {

    public String solve(String input) {
        int n = Integer.parseInt(input);

        boolean[] net = new boolean[n + 1]; // set erato net
        for (int i = 2; i < n + 1; i++) {
            if (net[i]) continue;
            for (int divisor = i * 2; divisor < n + 1; divisor += i) net[divisor] = true;
        }

        int[] primeArray = IntStream.rangeClosed(2, n).filter(i -> !net[i]).toArray();

        int count = 0;
        for (int i = 0; i < primeArray.length; i++) {
            int sum = 0;
            int idx = i;
            while (sum < n && idx < primeArray.length) sum += primeArray[idx++];
            if (sum == n) count++;
        }
        return String.valueOf(count);
    }
}
