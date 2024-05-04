package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ2343 {   //todo:

    public String solve(String input) {
        int m = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int[] lessons = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        int from = Arrays.stream(lessons).max().orElse(-1);    // Min possible dvd size.
        int to = Arrays.stream(lessons).sum(); // Max possible dvd size.

        while (from <= to) {
            int need = 0;
            int size = (from + to) / 2;

            int sum = 0;
            for (int lesson : lessons) {
                if (sum + lesson > size) {
                    need++;
                    sum = 0;
                }
                sum += lesson;
            }
            if (sum != 0) need++;

            if (need > m) from = size + 1;
            else to = size - 1;
        }

        return String.valueOf(from);
    }
}
