package org.alan.algorithm.practice.baekjoon.stepbystep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
    static int n;
    static int[] numbers;
    static int[] operations = new int[4];
    static int result;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        result = numbers[0];

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        keepOperate(0);
        System.out.print(max + "\n" + min);
    }

    static void keepOperate(int count) {
        if (count == n - 1) {
            if (max < result) {
                max = result;
            }
            if (min > result) {
                min = result;
            }
            result = numbers[0];

            return;
        }

        // operate with one and next value and save it in static variable
        // with the operation that left to use
        // count operations with count
        // initialize variable after end of counting

        for (int i = 0; i < 4; i++) {
            if (operations[i] != 0) {
                operations[i] -= 1;

                int operand = numbers[count + 1];

                switch (i) {
                    case 0 : result += operand; break;
                    case 1 : result -= operand; break;
                    case 2 : result *= operand; break;
                    case 3 : result /= operand; break;
                }

                keepOperate(count + 1);
                operations[i] += 1;
            }
        }
    }
}