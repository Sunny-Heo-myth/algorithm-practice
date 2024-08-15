package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839_4 {

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int bag = 0;

        while (true) {
            if (n%5 == 0) {
                bag += n/5;
                break;
            }
            n -= 3;
            bag++;
            if (n < 0) {
                bag = -1;
                break;
            }
        }

        System.out.println(bag);
    }
}
