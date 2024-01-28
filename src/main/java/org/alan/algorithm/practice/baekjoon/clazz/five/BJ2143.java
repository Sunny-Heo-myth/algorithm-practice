package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.regex.Pattern;

public class BJ2143 {

    public String solve(String input) {
        String[] lineArray = input.split("\n");
        int t = Integer.parseInt(lineArray[0]);
        int[] sumArray1 = getSumArray(lineArray[2]);
        int[] sumArray2 = getSumArray(lineArray[4]);
        int sum = 0;
        for (int s = 1; s < t; s++) {
            int case1 = countCombination(sumArray1, s);
            if (case1 == 0) continue;
            int case2 = countCombination(sumArray2, t - s);
            sum += case1 * case2;
        }
        return String.valueOf(sum);
    }

    private int[] getSumArray(String line) {
        int[] intArray = Pattern.compile(" ").splitAsStream(line).mapToInt(Integer::parseInt).toArray();
        int[] sumArray = new int[intArray.length + 1];
        int currentSum = 0;
        for (int i = 0; i < intArray.length; i++) {
            currentSum += intArray[i];
            sumArray[i + 1] = currentSum;
        }
        return sumArray;
    }

    private int countCombination(int[] sumArray, int sum) {
        int startInclusive = 0;
        int endExclusive = 1;
        int count = 0;
        while (startInclusive < sumArray.length && endExclusive < sumArray.length) {
            int currentSum = sumArray[endExclusive] - sumArray[startInclusive];
            if (currentSum < sum) endExclusive++;
            else if (currentSum > sum) startInclusive++;
            else {
                count++;
                endExclusive++;
            }
        }
        return count;
    }

}
