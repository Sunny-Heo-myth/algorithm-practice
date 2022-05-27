package com.baekjoonPractice.stepByStep.recursionStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11729 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        sb.append((int) (Math.pow(2, x) - 1)).append("\n");
        hanoi(1, 2, 3, x);
        System.out.println(sb);
    }


    static void hanoi(int from, int mid, int to, int n) {
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoi(from, to, mid, n - 1);
        sb.append(from + " " + to + "\n");
        hanoi(mid, from, to, n - 1);
    }
}
