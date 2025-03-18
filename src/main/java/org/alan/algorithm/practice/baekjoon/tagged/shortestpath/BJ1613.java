package org.alan.algorithm.practice.baekjoon.tagged.shortestpath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1613 {
    private final boolean[][] map;
    private final List<int[]> questions = new ArrayList<>();

    public BJ1613(String input) {
        int[][] lines = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int n = lines[0][0], k = lines[0][1];
        map = new boolean[n + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            int first = lines[i][0], second = lines[i][1];
            map[first][second] = true;
            map[second][first] = false;
        }
        for (int i = k + 2; i < k + 2 + lines[k + 1][0]; i++) questions.add(lines[i]);
    }

    public String solve() {
        for (int k = 1; k < map.length; k++) for (int i = 1; i < map.length; i++)
            if (map[i][k]) for (int j = 1; j < map.length; j++) if (map[k][j]) map[i][j] = true;

        return questions.stream()
                .map(e -> {
                    if (map[e[0]][e[1]]) return "-1";
                    else if (map[e[1]][e[0]]) return "1";
                    else return "0";
                })
                .collect(Collectors.joining("\n"));
    }
    
}
