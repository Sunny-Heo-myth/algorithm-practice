package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.Arrays;

public class BJ1063 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int[] king = toCoordinate(firstLine[0]); int[] stone = toCoordinate(firstLine[1]);

        for (int i = 1; i < lines.length; i++) {
            if (isMovable(king, lines[i])) continue;
            if (!Arrays.equals(move(king, lines[i]), stone)) {
                king = move(king, lines[i]);
            } else {
                if (isMovable(stone, lines[i])) continue;
                king = move(king, lines[i]);
                stone = move(stone, lines[i]);
            }
        }

        return fromCoordinate(king) + "\n" + fromCoordinate(stone);
    }

    private int[] toCoordinate(String place) {
        char[] xy = place.toCharArray();
        return new int[]{xy[0] - 'A', Integer.parseInt(String.valueOf(xy[1])) - 1};
    }

    private String fromCoordinate(int[] coordinate) {
        return String.valueOf((char) (coordinate[0] + 'A')) + (coordinate[1] + 1);
    }

    private int[] move(int[] from, String cmd) {
        int up = from[1] + 1;
        int left = from[0] - 1;
        int down = from[1] - 1;
        int right = from[0] + 1;
        return switch (cmd) {
            case  "T" -> new int[]{from[0], up};
            case  "L" -> new int[]{left, from[1]};
            case  "B" -> new int[]{from[0], down};
            case  "R" -> new int[]{right, from[1]};
            case "LT" -> new int[]{left, up};
            case "LB" -> new int[]{left, down};
            case "RB" -> new int[]{right, down};
            case "RT" -> new int[]{right, up};
            default -> throw new IllegalStateException("Unexpected value: " + cmd);
        };
    }

    private boolean isMovable(int[] from, String cmd) {
        int up = from[1] + 1;
        int left = from[0] - 1;
        int down = from[1] - 1;
        int right = from[0] + 1;
        return !switch (cmd) {
            case "T" -> up < 8;
            case "L" -> left >= 0;
            case "B" -> down >= 0;
            case "R" -> right < 8;
            case "LT" -> up < 8 && left >= 0;
            case "LB" -> down >= 0 && left >= 0;
            case "RB" -> down >= 0 && right < 8;
            case "RT" -> up < 8 && right < 8;
            default -> throw new IllegalStateException("Unexpected value: " + cmd);
        };
    }

}
