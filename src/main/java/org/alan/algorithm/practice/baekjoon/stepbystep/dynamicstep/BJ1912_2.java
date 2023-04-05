package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1912_2 {

    static int[] ints;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ints = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int max = ints[0];
        recursion(n - 1);
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int recursion(int n) {
        if (n == 0) {
            dp[n] = ints[n];
        }

        if (dp[n] == null) {
            dp[n] = Math.max(recursion(n - 1) + ints[n], ints[n]);
        }
        return dp[n];
    }
}
