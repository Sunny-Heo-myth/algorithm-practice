package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import java.util.regex.Pattern;

public class BJ2527 {
    private static final String NONE = "d";
    private static final String DOT = "c";
    private static final String LINE = "b";
    private static final String RECTANGLE = "a";

    public String solve(String input) {
        int[] dots = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
        int firstLowX = dots[0]; int firstLowY = dots[1]; int firstHighX = dots[2]; int firstHighY = dots[3];
        int secondLowX = dots[4]; int secondLowY = dots[5]; int secondHighX = dots[6]; int secondHighY = dots[7];
        if (firstLowX > secondHighX || firstHighX < secondLowX || firstLowY > secondHighY || firstHighY < secondLowY) return NONE;
        if ((firstLowX == secondHighX || firstHighX == secondLowX) && (firstLowY == secondHighY || firstHighY == secondLowY)) return DOT;
        if (firstLowX == secondHighX || firstHighY == secondLowY || firstLowY == secondHighY || firstHighX == secondLowX) return LINE;
        return RECTANGLE;
    }
}
