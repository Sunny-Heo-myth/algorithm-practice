package org.alan.algorithm.practice.baekjoon.stepbystep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463_2 {
    static Integer[] numberArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        numberArr = new Integer[N + 1];
        numberArr[0] = numberArr[1] = 0;

        System.out.print(recur(N));

    }

    static int recur(int N) {

        if (numberArr[N] == null) {
            if (N % 6 == 0) {
                numberArr[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            else if (N % 3 == 0) {
                numberArr[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            else if (N % 2 == 0) {
                numberArr[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            else {
                numberArr[N] = recur(N - 1) + 1;
            }
        }
        return numberArr[N];
    }
}
