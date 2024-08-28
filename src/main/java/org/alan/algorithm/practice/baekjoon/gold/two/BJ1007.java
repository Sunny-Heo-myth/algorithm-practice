package org.alan.algorithm.practice.baekjoon.gold.two;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1007 {
    private int[][] arr;
    private boolean[] checked;
    private int totalX;
    private int totalY;
    private double min = Double.MAX_VALUE;

    public String solve(String input) {
        arr = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        checked = new boolean[arr.length];

        totalX = Arrays.stream(arr).mapToInt(ints -> ints[0]).sum();
        totalY = Arrays.stream(arr).mapToInt(ints -> ints[1]).sum();
        min = Double.MAX_VALUE; // THERE IS ONLY ONE INSTANCE WHILE RUNNING!

        for (int i = 0; i < arr.length / 2 + 1; i++) {
            checked[i] = true;
            recur(1, i);
            checked[i] = false;
        }

        return String.valueOf(min);
    }

    private void recur(int size, int from) {
        if (size == checked.length / 2) {
            int x = IntStream.range(0, arr.length).filter(i -> checked[i]).map(i -> arr[i][0]).sum();
            int y = IntStream.range(0, arr.length).filter(i -> checked[i]).map(i -> arr[i][1]).sum();
            int xx = totalX - x, yy = totalY - y;
            min = Math.min(min, Math.sqrt(Math.pow(x - xx, 2) + Math.pow(y - yy, 2)));
            return;
        }

        for (int i = from + 1; i < checked.length; i++) {
            checked[i] = true;
            recur(size + 1, i);
            checked[i] = false;
        }
    }
}
