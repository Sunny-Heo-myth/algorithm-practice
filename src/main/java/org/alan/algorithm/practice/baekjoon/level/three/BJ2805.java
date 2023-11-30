package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class BJ2805 {
    public String solve(String input) {
        String[] s = input.split("\n");
        long n = Long.parseLong(s[0].split(" ")[1]);
        long[] woods = Pattern.compile(" ").splitAsStream(s[1]).sorted(Comparator.reverseOrder()).mapToLong(Long::parseLong).toArray();

        long cutAt = woods[0] - 1;
        while (cutAt >= 0) {
            long sum = 0;
            for (long wood : woods) {
                if (cutAt >= wood) break;
                sum += wood - cutAt;
            }

            if (sum >= n) return String.valueOf(cutAt);
            cutAt--;
        }
        return String.valueOf(0);
    }

    public String solve2(String input) {
        String[] s = input.split("\n");
        long n = Long.parseLong(s[0].split(" ")[1]);
        long[] woods = Pattern.compile(" ").splitAsStream(s[1]).mapToLong(Long::parseLong).toArray();

        long from = 0;
        long to = Arrays.stream(woods).max().orElse(0);
        while (from <= to) {
            long mid = (from + to) / 2;
            long sum = Arrays.stream(woods).map(l -> Long.max(l - mid, 0)).sum();
            if (sum >= n) from = mid + 1;
            else to = mid - 1;
        }
        return String.valueOf(to);
    }


}
