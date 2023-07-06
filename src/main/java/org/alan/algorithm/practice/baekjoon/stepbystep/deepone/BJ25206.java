package org.alan.algorithm.practice.baekjoon.stepbystep.deepone;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class BJ25206 {
    public double solve(String input) {
        double totalCredit = makeClassStream(input)
                .mapToDouble(strings -> Double.parseDouble(strings[1]))
                .sum();
        double sum = makeClassStream(input)
                .mapToDouble(strings -> Double.parseDouble(strings[1]) * Grade.from(strings[2]).score)
                .sum();

        return roundAt6th(sum / totalCredit);
    }

    private Stream<String[]> makeClassStream(String input) {
        return Arrays.stream(input.split("\n"))
                .map(s -> s.split(" "))
                .filter(strings -> !(Objects.equals(strings[2], "P")));
    }

    private double roundAt6th(double input) {
        return (double) Math.round(input * 1000000) / 1000000;
    }

    private enum Grade {
        APLUS(4.5)
        , AZERO(4.0)
        , BPLUS(3.5)
        , BZERO(3.0)
        , CPLUS(2.5)
        , CZERO(2.0)
        , DPLUS(1.5)
        , DZERO(1.0)
        , FZERO(0.0);

        private final double score;

        Grade(double score) {
            this.score = score;
        }

        private static Grade from(String s) {
            switch (s) {
                case "A+": return Grade.APLUS;
                case "A0": return Grade.AZERO;
                case "B+": return Grade.BPLUS;
                case "B0": return Grade.BZERO;
                case "C+": return Grade.CPLUS;
                case "C0": return Grade.CZERO;
                case "D+": return Grade.DPLUS;
                case "D0": return Grade.DZERO;
                case "F": return Grade.FZERO;
                default: throw new IllegalArgumentException();
            }
        }
    }

}
