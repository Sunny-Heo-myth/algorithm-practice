package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2869_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
        int[] input = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(strings[i]);
        }

        if (input[0] >= input[2]) {
            System.out.println(1);
        }
        else {
            int withoutLastDayAccumulated = input[2] - input[0];
            int i = withoutLastDayAccumulated / (input[0] - input[1]);
            if (withoutLastDayAccumulated % (input[0] - input[1]) == 0) {
                System.out.println(i + 1);
            }
            else {
                System.out.println(i + 2);
            }
        }
    }
}
