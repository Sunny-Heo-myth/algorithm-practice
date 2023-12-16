package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.alan.algorithm.lab.math.MatrixAlgebra;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ11403 {
    public String solve(String input) {
        int[][] adjacency = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        int[][] adjacency2 = new int[adjacency.length][adjacency.length];
        for (int i = 0; i < adjacency2.length; i++) System.arraycopy(adjacency[i], 0, adjacency2[i], 0, adjacency2.length);

        int count = counter(adjacency);
        int count2;
        while (true) {
            adjacency2 = toZeroOne(MatrixAlgebra.sum(MatrixAlgebra.multiply(adjacency, adjacency2), adjacency));
            count2 = counter(adjacency2);

            if (count == count2) break;
            count = count2;
        }

        return Arrays.stream(toZeroOne(adjacency2)).map(ints -> Arrays.stream(ints).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))).collect(Collectors.joining("\n"));
    }

    private int[][] toZeroOne(int[][] adjacency) {
        return Arrays.stream(adjacency).map(ints -> Arrays.stream(ints).map(i -> i == 0 ? 0 : 1).toArray()).toArray(int[][]::new);
    }

    private int counter(int[][] adjacency) {
        return Arrays.stream(adjacency).mapToInt(ints -> Arrays.stream(ints).map(i -> i != 0 ? 1 : 0).sum()).sum();
    }
}
