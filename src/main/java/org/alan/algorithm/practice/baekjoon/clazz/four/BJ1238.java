package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.Arrays;

public class BJ1238 {
    private int party;
    private int[][] edges;  // index refers vertix

    public String solve(String input) {
        parse(input);
        floydWarshall();
        return String.valueOf(longestFromShortest());
    }

    private void parse(String input) {
        String[] s = input.split("\n");
        int[] firstLine = getInts(s[0]);
        edges = new int[firstLine[0] + 1][firstLine[0] + 1];
        int NO_ROUTE = Integer.MAX_VALUE / 2;
        for (int[] ints : edges) Arrays.fill(ints, NO_ROUTE);
        for (int i = 1; i < edges.length; i++) edges[i][i] = 0;
        for (int i = 1; i < firstLine[1] + 1; i++) {
            int[] line = getInts(s[i]);
            edges[line[0]][line[1]] = line[2];
        }
        party = firstLine[2];
    }

    private int[] getInts(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private void floydWarshall() {
        for (int k = 1; k < edges.length; k++) for (int i = 1; i < edges.length; i++) for (int j = 1; j < edges.length; j++)
            edges[i][j] = Integer.min(edges[i][j], edges[i][k] + edges[k][j]);
    }

    private int longestFromShortest() {
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < edges.length; i++) result = Integer.max(edges[i][party] + edges[party][i], result);
        return result;
    }

}
