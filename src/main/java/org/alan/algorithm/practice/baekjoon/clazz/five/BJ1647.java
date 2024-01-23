package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1647 {
    private int[] parentArray;
    public String solve(String input) {
        parentArray = IntStream.rangeClosed(0, Integer.parseInt(input.split("\n")[0].split(" ")[0])).toArray();

        int[][] edgeArray = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .sorted(Comparator.comparingInt(edge -> edge[2])).toArray(int[][]::new);

        int answer = 0;
        int biggestCost = 0;
        for (int[] edge : edgeArray) {
            if (findRoot(edge[0]) != findRoot(edge[1])) {
                answer += edge[2];
                unify(edge[0], edge[1]);
                biggestCost = edge[2];
            }
        }
        return String.valueOf(answer - biggestCost);
    }

    private int findRoot(int vertex) {
        if (parentArray[vertex] == vertex) return vertex;
        return parentArray[vertex] = findRoot(parentArray[vertex]);
    }

    private void unify(int vertex1, int vertex2) {
        vertex1 = findRoot(vertex1);
        vertex2 = findRoot(vertex2);
        if (vertex1 != vertex2) parentArray[vertex2] = vertex1;
    }

}
