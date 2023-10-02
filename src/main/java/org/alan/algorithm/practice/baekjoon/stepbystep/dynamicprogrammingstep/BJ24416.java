package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicprogrammingstep;

public class BJ24416 {
    private long[] memory;
    private long m = 0;
    private long n = 0;

    public String solve(String input) {
        int number = Integer.parseInt(input);
        memory = new long[number + 1];  // memory[0] is blank
        memory[1] = 1;
        memory[2] = 1;
        recursiveFibonacci(number);
        dynamicFibonacci(number);
        return m + " " + n;
    }

    private long recursiveFibonacci(long number) {
        if (number == 1 || number == 2) {
            m++;
            return 1;
        }

        return recursiveFibonacci(number - 1) + recursiveFibonacci(number - 2);
    }

    private long dynamicFibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }

        for (int i = 3; i < number + 1; i++) {
            n++;
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[number];
    }

}
