package org.alan.algorithm.practice.baekjoon.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class BJ15486 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][2];
        int[] memo = new int[n + 2];

        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxProfit = -1;
        for (int i = 1; i <= n + 1; i++) {
            if (maxProfit < memo[i]) maxProfit = memo[i];
            int endDay = i + arr[i][0];
            if (endDay < n + 2) memo[endDay] = Math.max(memo[endDay], maxProfit + arr[i][1]);
        }
        System.out.print(memo[n + 1]);
    }

    public String solve(String input) {

        int[][] memo = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        return null;
    }
}
