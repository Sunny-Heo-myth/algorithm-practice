package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ7453 {
    public String solve(String input) {
        int[][] m = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int[] arr1 = IntStream.range(0, m.length).flatMap(i -> Arrays.stream(m).mapToInt(arr -> m[i][0] + arr[1])).sorted().toArray();
        int[] arr2 = IntStream.range(0, m.length).flatMap(i -> Arrays.stream(m).mapToInt(arr -> m[i][2] + arr[3])).sorted().toArray();
        int i = 0, j = arr2.length - 1; long count = 0;
        while (i < arr1.length && j >= 0) {
            int base1 = arr1[i], base2 = arr2[j];
            if (base1 + base2 < 0) i++;
            else if (base1 + base2 > 0) j--;
            else {
                long iCount = 0, jCount = 0;
                while (i < arr1.length && base1 == arr1[i]) { i++; iCount++; }
                while (j >= 0 && base2 == arr2[j]) { j--; jCount++; }
                count += iCount * jCount;
            }
        }
        return String.valueOf(count);
    }
}
