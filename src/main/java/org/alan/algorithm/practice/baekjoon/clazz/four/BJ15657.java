package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BJ15657 {
    private int size;
    private int[] array;
    private final List<Integer> ints = new ArrayList<>();
    private final StringBuilder answer = new StringBuilder();

    public String solve(String input) {
        String[] lines = input.split("\n");
        size = Integer.parseInt(lines[0].split(" ")[1]);
        array = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        recur(0, 0);
        return answer.substring(0, answer.length() - 1);
    }

    private void recur(int currentSize, int currentIndex) {
        if (currentSize == size) {
            answer.append(ints.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
            return;
        }

        for (int i = currentIndex; i < array.length; i++) {
            ints.add(array[i]);
            recur(currentSize + 1, i);
            ints.remove(ints.size() - 1);
        }

    }
}
