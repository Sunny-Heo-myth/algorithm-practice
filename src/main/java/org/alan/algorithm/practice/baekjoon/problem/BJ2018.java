package org.alan.algorithm.practice.baekjoon.problem;

public class BJ2018 {
    private final int N;

    public BJ2018(String input) {
        N = Integer.parseInt(input);
    }

    public String solve() {
        int count = 0, start = 1, end = 1, sum = 1;
        while (start <= N) {
            if (sum < N) sum += ++end;
            else if (sum > N) sum -= start++;
            else {
                count++;
                sum -= start++;
            }
        }
        return String.valueOf(count);
    }

}
