package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ2343 {

    public String solve(String input) {
        int m = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int[] lessons = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(lessons).max().orElse(-1);
        int sum = Arrays.stream(lessons).sum();
        
        while (max <= sum) {
            int mid = (max + sum) / 2;
            int currentSum = 0;
            int count = 0;
            for (int lesson : lessons) {
                if (currentSum + lesson > mid) {
                    count++; currentSum = 0;
                }
                currentSum += lesson;
            }
            if (currentSum != 0) count++;
            if (count > m) max = mid + 1;
            else sum = mid - 1;
        }
        return String.valueOf(max);
    }
}
