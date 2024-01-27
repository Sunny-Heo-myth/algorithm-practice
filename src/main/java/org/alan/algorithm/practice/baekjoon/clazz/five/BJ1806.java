package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ1806 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int sum = Integer.parseInt(lines[0].split(" ")[1]);
        int[] intArray = Pattern.compile(" ").splitAsStream(lines[1] + " 0").mapToInt(Integer::parseInt).toArray();

        int numberOfNumber = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;
        int currentSum = 0;
        while (startIdx < intArray.length && endIdx < intArray.length) {
            if (currentSum >= sum && numberOfNumber > endIdx - startIdx) numberOfNumber = endIdx - startIdx;

            if (currentSum < sum) currentSum += intArray[endIdx++];
            else currentSum -= intArray[startIdx++];
        }
        return numberOfNumber == Integer.MAX_VALUE ? "0" : String.valueOf(numberOfNumber);
    }

}
