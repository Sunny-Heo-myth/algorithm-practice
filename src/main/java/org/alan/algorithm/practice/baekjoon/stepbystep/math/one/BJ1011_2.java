package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1011_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = b - a;
            int distanceSqrt = (int) Math.sqrt(distance);
            if (distanceSqrt == Math.sqrt(distance)) s.append(distanceSqrt * 2 - 1).append("\n");
            else if (distanceSqrt * (distanceSqrt + 1) >= distance) s.append(distanceSqrt * 2).append("\n");
            else s.append(distanceSqrt * 2 + 1).append("\n");
        }
        System.out.print(s);
    }
}
