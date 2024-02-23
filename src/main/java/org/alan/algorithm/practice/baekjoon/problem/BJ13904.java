package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Comparator;
import java.util.regex.Pattern;

public class BJ13904 {
    public String solve(String input) {
        int[][] classArray = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .sorted(Comparator.comparingInt(c -> -c[0])).toArray(int[][]::new);

        boolean[] attendedClass = new boolean[classArray.length];

        int totalCredit = 0;
        for (int time = classArray[0][0]; time >= 1; time--) {
            int maxCredit = 0;
            int maxI = 0;
            for (int i = 0; i < classArray.length; i++) {
                if (classArray[i][0] < time) break;
                if (attendedClass[i]) continue;
                if (maxCredit < classArray[i][1]) {
                    maxCredit = classArray[i][1];
                    maxI = i;
                }
            }
            attendedClass[maxI] = true;
            totalCredit += maxCredit;
        }
        return String.valueOf(totalCredit);
    }

}
