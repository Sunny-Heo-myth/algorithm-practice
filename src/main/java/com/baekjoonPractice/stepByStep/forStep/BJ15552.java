package com.baekjoonPractice.stepByStep.forStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15552 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            String[] x = bf.readLine().split(" ");
            int y = Integer.parseInt(x[0]) + Integer.parseInt(x[1]);
            sb.append(y).append("\n");
        }
        System.out.println(sb);
    }

}
