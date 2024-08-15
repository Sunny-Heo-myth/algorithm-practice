package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1712 {

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(
                new InputStreamReader(System.in)).readLine(), " ");

        int fixedCost = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        if (price <= cost) System.out.print(-1);
        else System.out.print(fixedCost / (price - cost) + 1);
    }
}
