package org.alan.algorithm.practice.baekjoon.stepbystep.math.one;

public class BJ11005 {
    private StringBuilder output = new StringBuilder();
    private int base;
    private int number;
    public String solve(String input) {
        String[] s = input.split(" ");
        number = Integer.parseInt(s[0]);
        if (number == 0) {
            return String.valueOf(number);
        }

        base = Integer.parseInt(s[1]);

        int place = 0;
        while (number >= Math.pow(base, place)) {
            place++;
        }

        int remain = number;
        for (int i = place - 1; i >= 0; i--) {
            double x = Math.pow(base, i);
            int value = 0;
            while (remain >= x) {
                remain -= x;
                value++;
            }

            if (value > 9) {
                output.append((char) (value + 55));
            } else {
                output.append(value);
            }

        }
        return output.toString();
    }
}
