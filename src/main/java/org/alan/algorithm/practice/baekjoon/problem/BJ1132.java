package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BJ1132 {
    public String solve(String input) {
        char[][] lines = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        Vari[] varis = IntStream.range(0, 10).mapToObj(i -> new Vari()).toArray(Vari[]::new); // vari[0] represents 'A'
        for (char[] line : lines) {
            varis[line[0] - 'A'].digitOf1 = true;
            int power = line.length - 1;
            for (char ch : line) varis[ch - 'A'].coef += (long) Math.pow(10, power--);
        }

        long answer = 0;
        boolean[] used = new boolean[10];
        for (Vari vari : Arrays.stream(varis).sorted(Comparator.comparingLong(v -> v.coef)).toArray(Vari[]::new)) {
            int digit = IntStream.range(vari.digitOf1 ? 1 : 0, 10).filter(i -> !used[i]).findFirst().orElse(-1);
            used[digit] = true;
            answer += vari.coef * digit;
        }
        return String.valueOf(answer);
    }

    private class Vari {
        private long coef = 0;
        private boolean digitOf1 = false;
    }

}


