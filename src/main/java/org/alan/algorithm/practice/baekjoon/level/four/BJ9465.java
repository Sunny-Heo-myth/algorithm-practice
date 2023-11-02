package org.alan.algorithm.practice.baekjoon.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BJ9465 instance = new BJ9465();
        int tc = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();
        while (tc-- > 0) answer.append(instance.solve(bf.readLine() + "\n" + bf.readLine() + "\n" + bf.readLine())).append("\n");
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);

        // add dummy at the first element
        int[][] sticker = new int[2][n + 1];    // stateless
        sticker[0] = Arrays.stream(("0 " + s[1]).split(" ")).mapToInt(Integer::parseInt).toArray();
        sticker[1] = Arrays.stream(("0 " + s[2]).split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] memo = new int[2][n + 1];   // greedy
        memo[0][1] = sticker[0][1];
        memo[1][1] = sticker[1][1];

        for (int j = 2; j <= n; j++) {
            memo[0][j] = Math.max(memo[1][j - 1], memo[1][j - 2]) + sticker[0][j];
            memo[1][j] = Math.max(memo[0][j - 1], memo[0][j - 2]) + sticker[1][j];
        }

        return String.valueOf(Integer.max(memo[0][n], memo[1][n]));
    }

}
