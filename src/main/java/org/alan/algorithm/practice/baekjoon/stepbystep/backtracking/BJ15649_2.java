package org.alan.algorithm.practice.baekjoon.stepbystep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649_2 {

    static int N;
    static int M;
    static boolean[] check;
    static int[] printArray;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        printArray = new int[M];
        sb = new StringBuilder();

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int count) {

        if (count == M) {
            for (int i : printArray) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                printArray[count] = i + 1;
                check[i] = true;
                dfs(count + 1);
                check[i] = false;
            }
        }


    }
}
