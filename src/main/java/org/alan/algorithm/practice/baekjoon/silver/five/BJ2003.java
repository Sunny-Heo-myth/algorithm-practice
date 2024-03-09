package org.alan.algorithm.practice.baekjoon.silver.five;

import java.util.regex.Pattern;

public class BJ2003 {
    public String solve(String input) {
        String[] lineArray = input.split("\n");
        int targetSum = Integer.parseInt(lineArray[0].split(" ")[1]);
        int[] intArray = Pattern.compile(" ").splitAsStream(lineArray[1]).mapToInt(Integer::parseInt).toArray();
        int count = 0;
        for (int i = 0; i < intArray.length; i++) {
            int sum = 0;
            for (int j = i; j < intArray.length; j++) {
                sum += intArray[j];
                if (sum == targetSum) count++;
                else if (sum > targetSum) break;
            }
        }
        return String.valueOf(count);
    }

    public String solve2(String input) {
        String[] lineArray = input.split("\n");
        int targetSum = Integer.parseInt(lineArray[0].split(" ")[1]);
        int[] intArray = Pattern.compile(" ").splitAsStream(lineArray[1]).mapToInt(Integer::parseInt).toArray();

        int[] sumArray = new int[intArray.length + 1];
        int cumulative = 0;
        for (int sumArrayIdx = 1; sumArrayIdx < sumArray.length; sumArrayIdx++) {
            cumulative += intArray[sumArrayIdx - 1];
            sumArray[sumArrayIdx] = cumulative;
        }

        int count = 0;
        for (int i = 0; i < sumArray.length - 1; i++) {
            for (int j = i + 1; j < sumArray.length; j++) {
                int sum = sumArray[j] - sumArray[i];
                if (sum == targetSum) count++;
                else if (sum > targetSum) break;
            }
        }
        return String.valueOf(count);
    }
}
