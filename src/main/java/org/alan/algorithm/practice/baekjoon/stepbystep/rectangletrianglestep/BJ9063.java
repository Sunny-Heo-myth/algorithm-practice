package org.alan.algorithm.practice.baekjoon.stepbystep.rectangletrianglestep;

public class BJ9063 {

    public String solve(String input) {
        if (input.split("\n").length == 2) {
            return "0";
        }

        int[][] dots = toIntArray(input);
        long left = 10000;
        long right = -10000;
        long up = -10000;
        long down = 10000;
        for (int[] dot : dots) {
            int x = dot[0];
            int y = dot[1];
            left = Long.min(left, x);
            right = Long.max(right, x);
            up = Long.max(up, y);
            down = Long.min(down, y);
        }
        return String.valueOf((right - left) * (up - down));
    }

    private int[][] toIntArray(String input) {
        String[] lines = input.split("\n");

        int[][] dots = new int[lines.length - 1][2];
        for (int i = 1; i < lines.length; i++) {
            String[] xy = lines[i].split(" ");
            dots[i - 1] = new int[]{Integer.parseInt(xy[0]), Integer.parseInt(xy[1])};
        }
        return dots;
    }
}
