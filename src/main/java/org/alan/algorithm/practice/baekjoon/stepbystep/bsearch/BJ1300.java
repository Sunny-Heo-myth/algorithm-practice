package org.alan.algorithm.practice.baekjoon.stepbystep.bsearch;

import java.util.stream.IntStream;

public class BJ1300 {

    public String solve(String input) {
        String[] s = input.split("\n");
        int N = Integer.parseInt(s[0]), K = Integer.parseInt(s[1]);
        int low = 0, high = K;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (IntStream.rangeClosed(1, N).map(i -> Math.min(N, mid / i)).sum() < K) low = mid;
            else high = mid;
        }
        return String.valueOf(high);
    }

}
