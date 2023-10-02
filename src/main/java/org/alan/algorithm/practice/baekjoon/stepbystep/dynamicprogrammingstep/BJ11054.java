package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicprogrammingstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11054 {
    static int input;
    static int[] numbers;
    static Integer[] dp;
    static Integer[] dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(bf.readLine());
        numbers = new int[input];
        dp = new Integer[input];
        dp2 = new Integer[input];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < input; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < input; i++) {
            dp[i] = bitonic(i);
        }
        for (int i = 0; i < input; i++) {
            dp2[i] = backtonic(i);
        }

        int maxLength = 1;
        for (int i = 0; i < input; i++) {
            maxLength = Math.max(maxLength, dp[i] + dp2[i]);
        }
        System.out.print(maxLength);
    }

    static int bitonic(int i) {
        if (dp[i] == null) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], bitonic(j) + 1);

                }
            }
        }
        return dp[i];
    }

    static int backtonic(int i) {
        if (dp2[i] == null) {
            dp2[i] = 0;
            for (int j = i + 1; j < input; j++) {
                if (numbers[j] < numbers[i]) {
                    dp2[i] = Math.max(dp2[i], backtonic(j) + 1);
                }
            }
        }
        return dp2[i];
    }
}
