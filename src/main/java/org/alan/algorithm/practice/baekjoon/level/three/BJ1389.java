package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.Arrays;

public class BJ1389 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int numberOfVertices = Integer.parseInt(firstLine[0]);
        int[][] map = new int[numberOfVertices + 1][numberOfVertices + 1];
        Arrays.stream(map).forEach(ints -> Arrays.fill(ints, 5001));
        Arrays.stream(lines).skip(1).forEach(s -> {
            String[] ss = s.split(" ");
            int i = Integer.parseInt(ss[0]);
            int j = Integer.parseInt(ss[1]);
            map[i][j] = 1;
            map[j][i] = 1;
        });

        for (int k = 1; k < map.length; k++) for (int i = 1; i < map.length; i++) for (int j = 1; j < map.length; j++) {
            if (map[i][k] + map[k][j] < map[i][j]) map[i][j] = map[i][k] + map[k][j];
        }

        for (int k = 1; k < map.length; k++) map[k][k] = 0;

        int personNo = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            int sum = Arrays.stream(map[i]).sum();
            if (sum < min) {
                min = sum;
                personNo = i;
            }
        }
        return String.valueOf(personNo);
    }
}
