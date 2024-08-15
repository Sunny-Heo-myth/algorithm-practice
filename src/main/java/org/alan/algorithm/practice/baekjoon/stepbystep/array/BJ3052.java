package org.alan.algorithm.practice.baekjoon.stepbystep.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3052 {

    public static void main(String[] args) throws IOException {
        int[] array = new int[42];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int now = Integer.parseInt(bf.readLine());
            array[now % 42]++;
        }
        int count = 0;
        for (int i : array) {
            if (i != 0) count++;
        }
        System.out.println(count);
    }
}
