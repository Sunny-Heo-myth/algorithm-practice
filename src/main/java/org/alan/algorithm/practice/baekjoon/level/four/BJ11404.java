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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BJ11404 instance = new BJ11404();
        instance.numberOfVertix = Integer.parseInt(br.readLine());
        instance.relation = new int[instance.numberOfVertix][instance.numberOfVertix];
        for (int[] ints : instance.relation) Arrays.fill(ints, NO_ROUTE);
        int line = Integer.parseInt(br.readLine());
        while (line-- > 0) instance.updateEdge(br.readLine());

        instance.floydWarshall();
        instance.write(instance.relation);
        br.close();
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

    private void write(int[][] relation) {
        for (int i = 0; i < numberOfVertix; i++) for (int j = 0; j < numberOfVertix; j++)
            relation[i][j] = relation[i][j] == NO_ROUTE ? 0 : relation[i][j];

        System.out.print(Arrays.stream(relation)
                .map(ints -> Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n")));
    }
}
