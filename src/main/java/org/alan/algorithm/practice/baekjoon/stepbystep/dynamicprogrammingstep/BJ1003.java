package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicprogrammingstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {

    static int n;
    static int[] dpArray = new int[41];

    public static void main(String[] args) throws IOException {

        dpArray[0] = 0;
        dpArray[1] = 1;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bf.readLine());

            if (number == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            } else {
                sb.append(fibo(number - 1)).append(" ").append(fibo(number)).append("\n");
            }

        }
        System.out.print(sb);

    }

    static int fibo(int num) {

        if (num <= 1) {
            return dpArray[num];
        }

        if (dpArray[num] == 0) {
            dpArray[num] = fibo(num - 1) + fibo(num - 2);
        }

        return dpArray[num];
    }
}
