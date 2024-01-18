package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class BJ1208 {
    private long[] longArray;

    public String solve(String input) {
        String[] lines = input.split("\n");
        int sum = Integer.parseInt(lines[0].split(" ")[1]);
        longArray = Pattern.compile(" ").splitAsStream(lines[1]).mapToLong(Long::parseLong).toArray();
        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();

        getSubsequence(0, longArray.length / 2, 0, leftList);
        getSubsequence(longArray.length / 2, longArray.length, 0, rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        int leftPointer = 0;
        int rightPointer = rightList.size() - 1;
        long count = 0;

        while (leftPointer < leftList.size() && rightPointer >= 0) {
            long pointSum = leftList.get(leftPointer) + rightList.get(rightPointer);

            if (pointSum == sum) {
                long a = leftList.get(leftPointer);
                long leftCount = 0;
                while (leftPointer < leftList.size() && leftList.get(leftPointer) == a) {
                    leftPointer++;
                    leftCount++;
                }

                long b = rightList.get(rightPointer);
                long rightCount = 0;
                while (rightPointer >= 0 && rightList.get(rightPointer) == b) {
                    rightPointer--;
                    rightCount++;
                }

                count += leftCount * rightCount;
            }

            else if (pointSum < sum) leftPointer++;
            else rightPointer--;
        }

        if (sum == 0) count--;
        return String.valueOf(count);
    }


    private void getSubsequence(int startInclusive, int endExclusive, long sum, List<Long> list) {
        if (startInclusive == endExclusive) {
            list.add(sum);
            return;
        }

        getSubsequence(startInclusive + 1, endExclusive, sum + longArray[startInclusive], list);
        getSubsequence(startInclusive + 1, endExclusive, sum, list);
    }

}
