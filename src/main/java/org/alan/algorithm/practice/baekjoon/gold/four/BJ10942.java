package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ10942 {
    public String solve(String input) {
        int[] ints = input.lines().skip(1).limit(1).flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();

        boolean[][] memo = new boolean[ints.length][ints.length];
        for (int i = 0; i < ints.length; i++) memo[i][i] = true;

        for (int i = 0; i < ints.length; i++) {
            int sii = i - 1; int eii = i + 1;
            while (sii >= 0 && eii < ints.length)
                if (ints[sii] == ints[eii]) memo[sii--][eii++] = true;
                else break;
        }



        return Pattern.compile("\n").splitAsStream(input).skip(3)
                .map(s -> {
                    int[] ii = Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray();
                    return memo[ii[0] - 1][ii[1] - 1] ? "1" : "0";
                }).collect(Collectors.joining("\n"));
    }
}
