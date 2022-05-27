package com.baekjoonPractice.stepByStep.math1Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(bf.readLine());
        for (int i = 0; i < nn; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int quotient = n / h;
            int remainder = n % h;
            if (remainder == 0) System.out.println(h * 100 + quotient);
            else System.out.println(remainder * 100 + quotient + 1);
        }
    }
}
