package com.baekjoonPractice.stepByStep.dynamicProgrammingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865_2 {
    static int[][] items;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int totalW = Integer.parseInt(st.nextToken());

        items = new int[n][2];
        dp = new Integer[n][totalW + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        System.out.print(recursion(n - 1, totalW));
    }

    static int recursion(int x, int y) {
        if (x < 0) {
            return 0;
        }

        if (dp[x][y] == null) {
            if (items[x][0] > y) {
                dp[x][y] = recursion(x - 1, y);
            }
            else {
                dp[x][y] = Math.max(recursion(x - 1, y),
                        recursion(x - 1, y - items[x][0]) + items[x][1]);
            }
        }
        return dp[x][y];
    }
}
