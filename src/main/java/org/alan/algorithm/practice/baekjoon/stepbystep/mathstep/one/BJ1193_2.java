package org.alan.algorithm.practice.baekjoon.stepbystep.mathstep.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1193_2 {

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int diagonal = 1, sum = 0;
        while (true) {
            if (x <= diagonal + sum) {
                if (diagonal % 2 == 1) {
                    System.out.print(diagonal - (x - sum) + 1 + "/" + (x - sum)); break;
                } else {
                    System.out.print(x - sum + "/" + (diagonal - (x - sum) + 1)); break;
                }
            } else {
                sum += diagonal;
                diagonal++;
            }
        }
    }
}
