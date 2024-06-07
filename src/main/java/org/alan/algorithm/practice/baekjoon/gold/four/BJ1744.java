package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1744 {
    public String solve(String input) {
        int[] arr = Pattern.compile("\n").splitAsStream(input).skip(1).mapToInt(Integer::parseInt).sorted().toArray();
        if (arr.length == 1) return String.valueOf(arr[0]);

        int sum = IntStream.iterate(0, i -> i < arr.length && arr[i + 1] < 0, i -> i + 2).map(i -> arr[i] * arr[i + 1]).sum()
                + IntStream.iterate(arr.length - 1, i -> i - 1 >= 0 && arr[i - 1] > 0, i -> i - 2)
                .map(i -> Math.max(arr[i] * arr[i - 1], arr[i] + arr[i - 1])).sum();

        long nCount = Arrays.stream(arr).takeWhile(i -> i < 0).count();
        long pCount = IntStream.iterate(arr.length - 1, i -> i >= 0 && arr[i] > 0, i -> i - 1).count();
        int lastN = nCount > 0 ? arr[(int) (nCount - 1)] : 0;
        int lastP = pCount > 0 ? arr[(int) (arr.length - pCount)] : 0;

        if (nCount % 2 == 0 && pCount % 2 == 0) return String.valueOf(sum);
        if (nCount % 2 == 0) return String.valueOf(sum + lastP);
        if (pCount % 2 == 0 && (nCount + pCount) == arr.length) return String.valueOf(sum + lastN);
        if (pCount % 2 == 0) return String.valueOf(sum);
        if (nCount + pCount == arr.length) return String.valueOf(sum + lastN + lastP);
        return String.valueOf(sum + lastP);
    }

    public String solve2(String input) {
        int total = 0; int k;

        int[] n = Pattern.compile("\n").splitAsStream(input).skip(1).mapToInt(Integer::parseInt)
                .sorted().takeWhile(i -> i <= 0).toArray();
        k = 0; while (k < n.length)
            if (k + 1 < n.length) total += n[k++] * n[k++];
            else total += n[k++];

        int[] p = Pattern.compile("\n").splitAsStream(input).skip(1).map(Integer::parseInt)
                .sorted(Comparator.reverseOrder()).takeWhile(i -> i > 0).mapToInt(Integer::intValue).toArray();
        k = 0; while (k < p.length)
            if (k + 1 < p.length && p[k] != 1 && p[k + 1] != 1) total += p[k++] * p[k++];
            else total += p[k++];

        return String.valueOf(total);
    }
}
