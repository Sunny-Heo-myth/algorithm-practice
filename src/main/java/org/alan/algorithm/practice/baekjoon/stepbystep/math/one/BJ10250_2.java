package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10250_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nn; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int quotient = n / h;
            if (n % h == 0) System.out.println(h * 100 + n / h);
            else System.out.println((n % h) * 100 + (n / h));
        }
    }
}
