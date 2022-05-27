package com.baekjoonPractice.stepByStep.dynamicProgrammingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10844 {

    static Long[][] numbers; // long[d][v] is number of cases with d'th digit = d & the value = v.
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        numbers = new Long[input + 1][10];
        for (int i = 0; i < 10; i++) {
            numbers[1][i] = 1L;
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += stairNum(input, i);
        }
        System.out.print(result % MOD);
    }

    static long stairNum(int digit, int value) {
        if (digit == 1) {
            return numbers[digit][value];
        }

        if (numbers[digit][value] == null) {
            if (value == 0) {
                numbers[digit][value] = stairNum(digit - 1, 1);
            }
            else if (value == 9) {
                numbers[digit][value] = stairNum(digit - 1, 8);
            }
            else {
                numbers[digit][value] = stairNum(digit - 1, value + 1) + stairNum(digit - 1, value - 1);
            }
        }
        return numbers[digit][value] % MOD;
    }
}
