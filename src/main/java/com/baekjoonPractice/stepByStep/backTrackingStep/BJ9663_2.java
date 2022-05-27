package com.baekjoonPractice.stepByStep.backTrackingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663_2 {
    static int[] queens;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        queens = new int[n];

        nQueen(0);

        System.out.print(count);
    }

    public static void nQueen(int depth) {

        // if fill up with n rows, count + 1
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            queens[depth] = i;

            if (queenRoute(depth)) {
                nQueen(depth + 1);
            }

        }
    }

    public static boolean queenRoute(int column) {
        for (int i = 0; i < column; i++) {

            // There should not be same number in queens which means there is 2 queen in same row
            if (queens[column] == queens[i]) {
                return false;
            }
            else if (Math.abs(column - i) == Math.abs(queens[column] - queens[i])) {
                return false;
            }
        }
        return true;
    }

}
