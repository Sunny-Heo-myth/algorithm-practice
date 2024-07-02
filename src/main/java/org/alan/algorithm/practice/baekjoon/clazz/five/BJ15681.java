package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ15681 {
    private int[] numberOfChild;
    private List<List<Integer>> adjacency;

    public String solve(String input) {
        int[] firstLine = input.lines().findFirst().stream().flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        int n = firstLine[0], r = firstLine[1];

        numberOfChild = new int[n + 1]; Arrays.fill(numberOfChild, 1);
        adjacency = new ArrayList<>(); for (int i = 0; i <= n; i++) adjacency.add(new ArrayList<>());

        input.lines().skip(1).limit(n - 1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .forEach(vertices -> {adjacency.get(vertices[0]).add(vertices[1]); adjacency.get(vertices[1]).add(vertices[0]);});

        traverse(r, -1);
        return input.lines().skip(n).map(s ->
                String.valueOf(numberOfChild[Integer.parseInt(s)])).collect(Collectors.joining("\n"));
    }

    private void traverse(int from, int parent) {
        for (int to : adjacency.get(from)) if (to != parent) traverse(to, from);
        if (parent != -1) numberOfChild[parent] += numberOfChild[from];
    }

}
