package org.alan.algorithm.practice.baekjoon.bronze;

import java.time.LocalDate;

public class BJ1924 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int month = Integer.parseInt(s[0]);
        int date = Integer.parseInt(s[1]);
        LocalDate localDate = LocalDate.of(2007, month, date);
        return localDate.getDayOfWeek().name().substring(0, 3);
    }
}
