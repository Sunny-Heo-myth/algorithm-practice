package com.baekjoonPractice.stepByStep.backTrackingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888_2 {
    static int n;
    static int[] numbers;
    static int[] operations = new int[4];
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

        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(st.nextToken());
        }

        keepOperate(numbers[0], 1);
        System.out.print(max + "\n" + min);
    }

    static void keepOperate(int operand, int count) {

        if (count == n) {
            max = Math.max(max, operand);
            min = Math.min(min, operand);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operations[i] > 0) {
                operations[i]--;

                switch (i) {
                    case 0 : keepOperate(operand + numbers[count], count + 1); break;
                    case 1 : keepOperate(operand - numbers[count], count + 1); break;
                    case 2 : keepOperate(operand * numbers[count], count + 1); break;
                    case 3 : keepOperate(operand / numbers[count], count + 1); break;
                }

                operations[i]++;
            }
        }
    }
}
