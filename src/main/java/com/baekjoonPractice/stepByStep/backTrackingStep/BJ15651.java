package com.baekjoonPractice.stepByStep.backTrackingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
    static int N;
    static int M;
    static boolean[] booleans;
    static int[] ints;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        booleans = new boolean[N];
        ints = new  int[M];
        stringBuilder = new StringBuilder();

        dfs(0);
        System.out.print(stringBuilder);
    }

    static void dfs(int count) {
        if (count == M) {
            for (int i : ints) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            ints[count] = i;
            dfs(count + 1);
        }
    }
}
