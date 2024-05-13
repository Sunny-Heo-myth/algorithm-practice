package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.stream.Collectors;

public class BJ16139 {
    public String solve(String input) {
        char[] firstLine = input.split("\n")[0].toCharArray();
        int[][] memo = new int[26][firstLine.length + 1];

        for (int i = 0; i < firstLine.length; i++) {
            for (int j = 0; j < 26; j++) memo[j][i + 1] = memo[j][i];
            memo[firstLine[i] - 'a'][i + 1]++;
        }

        return input.lines().skip(2).map(s -> {
                    String[] sp = s.split(" "); char a = (char) (sp[0].charAt(0) - 'a');
                    return String.valueOf(memo[a][Integer.parseInt(sp[2]) + 1] - memo[a][Integer.parseInt(sp[1])]);
                }).collect(Collectors.joining("\n"));
    }
}
