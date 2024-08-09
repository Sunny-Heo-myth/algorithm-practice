package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BJ1132 {
    public String solve(String input) {
        char[][] lines = input.lines().skip(1).map(String::toCharArray).toArray(char[][]::new);
        Vari[] varis = IntStream.range(0, 10).mapToObj(i -> new Vari()).toArray(Vari[]::new); // vari[0] represents 'A'
        for (char[] line : lines) {
            int power = line.length - 1;
            if (power == 0) {
                varis[line[0] - 'A'].coefficient++;
                varis[line[0] - 'A'].digitOf1 = true;
            } else {
                for (char c : line) varis[c - 'A'].coefficient += (long) Math.pow(10, power--);
            }
        }

        Vari[] sorted = Arrays.stream(varis).sorted(Comparator.comparingLong(v -> -v.coefficient)).toArray(Vari[]::new);
        if (sorted[9].coefficient == 0) {
            int n = 9;
            long answer = 0;
            for (Vari v : sorted) answer += v.coefficient * n--;
            return String.valueOf(answer);
        } else {
            long answer = 0;

            int i = 0;
            long nLeft = Arrays.stream(varis).filter(v -> v.digitOf1).count();
            int n = 9;
            while (i < sorted.length - nLeft) {
                if (sorted[i].digitOf1) nLeft--;
                answer += sorted[i].coefficient * n--;
                i++;
            }
            while (++i < sorted.length) {
                answer += sorted[i].coefficient * n--;
            }

            return String.valueOf(answer);
        }
    }

    private class Vari {
        private long coefficient = 0;
        private boolean digitOf1 = false;
    }

}


