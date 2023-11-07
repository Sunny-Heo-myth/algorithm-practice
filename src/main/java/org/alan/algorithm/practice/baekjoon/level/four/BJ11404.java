package org.alan.algorithm.practice.baekjoon.level.four;

import org.alan.algorithm.lab.math.MatrixAlgebra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ11404 {
    private int numberOfVertix;
    private int[][] relation;
    private static final int NO_ROUTE = 100000001;

    public String solve(String input) {
        String[] s = input.split(" ");
        numberOfVertix = Integer.parseInt(s[0]);
        relation = new int[numberOfVertix][numberOfVertix];
        for (int[] ints : relation) Arrays.fill(ints, NO_ROUTE);
        Arrays.stream(s).skip(2).forEach(this::updateEdge);
        floydWarshall();
        return write(relation);
    }

    private void updateEdge(String s) {
        String[] ss = s.split(" ");
        int i = Integer.parseInt(ss[0]) - 1;
        int j = Integer.parseInt(ss[1]) - 1;
        relation[i][j] = Integer.min(relation[i][j], Integer.parseInt(ss[2]));
    }

    private void floydWarshall() {
        for (int k = 0; k < numberOfVertix; k++) for (int i = 0; i < numberOfVertix; i++) for (int j = 0; j < numberOfVertix; j++)
            if (i == j) relation[i][j] = 0;
            else relation[i][j] = Integer.min(relation[i][j], relation[i][k] + relation[k][j]);
    }

    private String write(int[][] relation) {
        for (int i = 0; i < numberOfVertix; i++) for (int j = 0; j < numberOfVertix; j++)
            relation[i][j] = relation[i][j] == NO_ROUTE ? 0 : relation[i][j];

        return Arrays.stream(relation)
                .map(ints -> Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }
}
