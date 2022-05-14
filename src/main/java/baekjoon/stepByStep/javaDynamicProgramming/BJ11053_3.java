package baekjoon.stepByStep.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Think simple as possible.
public class BJ11053_3 {
    static int[] numbers;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        numbers = new int[input];
        dp = new Integer[input];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < input; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < input; i++) {
            dp[i] = recur(i);
        }

        int max = dp[0];
        for (int i = 1; i < input; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }

    static int recur(int i) {

        if (dp[i] == null) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i]) {
                    dp[i] = Math.max(dp[i], recur(j) + 1);
                }
            }
        }
        return dp[i];
    }
}
