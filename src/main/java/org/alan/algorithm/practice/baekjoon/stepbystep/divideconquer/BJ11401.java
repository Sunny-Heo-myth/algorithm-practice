package org.alan.algorithm.practice.baekjoon.stepbystep.divideconquer;

public class BJ11401 {
    private final long P = 1_000_000_007;

    public String solve(String input) {
        String[] split = input.split(" ");
        int N = Integer.parseInt(split[0]), K = Integer.parseInt(split[1]);
        long[] facto = new long[N + 1]; facto[0] = 1; facto[1] = 1; // Factorial array.
        for (int i = 1; i < facto.length; i++) facto[i] = (facto[i - 1] * i) % P;

        long deno = facto[K] * facto[N - K] % P;
        return String.valueOf(facto[N] * pow(deno, P - 2) % P);
    }

    private long pow(long base, long exp) {
        if (exp == 1) return base % P;

        long temp = pow(base, exp / 2);
        if (exp % 2 == 1) return (temp * temp % P) * base % P;
        return temp * temp % P;
    }
}
