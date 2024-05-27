package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.regex.Pattern;

public class BJ2110 {
    private int[] X;
    private int C;

    public String solve(String input) {
        X = Pattern.compile("\n").splitAsStream(input).skip(1).mapToInt(Integer::parseInt).sorted().toArray();
        C = Integer.parseInt(input.split("\n")[0].split(" ")[1]);

        int left = 1; int right = X[X.length - 1] - X[0]; int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceRouter(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return String.valueOf(result);
    }

    private boolean canPlaceRouter(int distance) {
        int count = 1; int lastRouter = X[0];
        for (int i = 1; i < X.length; i++) if (X[i] - lastRouter >= distance) {
            lastRouter = X[i];
            if (C == ++count) return true;
        }
        return false;
    }
}
