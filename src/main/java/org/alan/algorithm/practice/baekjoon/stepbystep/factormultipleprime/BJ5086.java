package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime;

public class BJ5086 {
    public String solve(String input) {
        String[] strings = input.split(" ");
        int firstN = Integer.parseInt(strings[0]);
        int secondN = Integer.parseInt(strings[1]);

        if (secondN % firstN == 0) {
            return "factor";
        } else if (firstN % secondN == 0) {
            return "multiple";
        } else {
            return "neither";
        }

    }
}
