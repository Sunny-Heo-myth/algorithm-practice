package org.alan.algorithm.practice.baekjoon.tagged.bt;

import java.util.Arrays;

public class BJ15684 {
    private final boolean[][] ladders;
    private int min = 4;

    public BJ15684(String input) {
        String[] lines = input.split("\n");
        int[] fl = Arrays.stream(lines[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        ladders = new boolean[fl[2] - 1][fl[0]];
    }

    public String solve() {

        return String.valueOf(min == 4 ? -1 : min);
    }

    private void recur(int count, int x, int y) {
        // prune caused by exceeding
        if (count == 4) return;

        // simulate & min update
        boolean flag = false;
        for (int p = 0; p < ladders[0].length; p++) {
            int py = p, px = 0;

        }
        if (flag) min = Math.min(min, count);

        // make next ladder & backtrack if it fails
        for () {

        }
    }

}
