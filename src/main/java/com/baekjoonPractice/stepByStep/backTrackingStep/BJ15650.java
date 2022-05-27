package com.baekjoonPractice.stepByStep.backTrackingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650 {
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

        dfs(1, 0);
        System.out.print(stringBuilder);
    }

    static void dfs(int at, int count) {
        if (count == M) {
            for (int i : ints) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            ints[count] = i;
            dfs(i + 1, count + 1);
        }
    }
}
