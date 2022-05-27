package com.baekjoonPractice.stepByStep.dynamicProgrammingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865 {
    static Integer[][] dp;
    static int[] weights;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine(), " ");
        int numberOfItem = Integer.parseInt(st.nextToken());
        int totalWeight = Integer.parseInt(st.nextToken());
        weights = new int[numberOfItem];
        values = new int[numberOfItem];
        dp = new Integer[numberOfItem][totalWeight + 1];

        for (int i = 0; i < numberOfItem; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(numberOfItem - 1, totalWeight));
    }

    static int knapsack(int n, int w) {
        if (n < 0) {
            return 0;
        }

        if (dp[n][w] == null) {
            if (weights[n] > w) {
                dp[n][w] = knapsack(n - 1, w);
            }
            else {
                dp[n][w] = Math.max(knapsack(n - 1, w),
                        knapsack(n - 1, w - weights[n]) + values[n]);
            }
        }
        return dp[n][w];
    }
}

