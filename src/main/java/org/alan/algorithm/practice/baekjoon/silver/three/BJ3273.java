package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;

public class BJ3273 {

    public String solve(String input) {
        String[] line = input.split("\n");
        int[] numbers = Pattern.compile(" ").splitAsStream(line[1]).mapToInt(Integer::parseInt).sorted().toArray();
        int sum = Integer.parseInt(line[2]);

        int i = 0;
        int j = numbers.length - 1;
        int count = 0;
        while (i < j) {
            int temp = numbers[i] + numbers[j];
            if (temp < sum) {
                i++;
            } else if (temp > sum) {
                j--;
            } else {
                count++;
                i++;
            }
        }
        return String.valueOf(count);
    }
}
