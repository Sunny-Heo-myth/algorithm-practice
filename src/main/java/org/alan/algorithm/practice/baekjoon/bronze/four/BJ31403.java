package org.alan.algorithm.practice.baekjoon.bronze.four;

import java.util.regex.Pattern;

public class BJ31403 {
    public String solve(String input) {
        int[] arr = Pattern.compile("\n").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        String[] sarr = Pattern.compile("\n").splitAsStream(input).toArray(String[]::new);
        return arr[0] + arr[1] - arr[2] + "\n" + (Integer.parseInt(sarr[0] + sarr[1]) - arr[2]);
    }
}
