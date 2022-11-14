package practice.baekjoon.stepbystep.dynamicProgrammingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156_2 {

    static int[] ints;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        ints = new int[input + 1];
        dp = new Integer[input + 1];
        for (int nthWine = 1; nthWine <= input; nthWine++) {
            ints[nthWine] = Integer.parseInt(bf.readLine());
        }

        dp[0] = 0;
        dp[1] = ints[1];
        if (input > 1) {
            dp[2] = ints[1] + ints[2];
        }
        System.out.print(maxSum(input));
    }

    static public int maxSum(int nthWine) {
        if (nthWine <= 2) {
            return dp[nthWine];
        }
        if (dp[nthWine] == null) {
            dp[nthWine] = Math.max(
                    Math.max(maxSum(nthWine - 2), maxSum(nthWine - 3) + ints[nthWine - 1]) + ints[nthWine],
                    maxSum(nthWine - 1));
        }
        return dp[nthWine];
    }
}
