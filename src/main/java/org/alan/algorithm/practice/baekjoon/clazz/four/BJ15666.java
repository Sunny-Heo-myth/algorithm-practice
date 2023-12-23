package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BJ15666 {
    private int length;
    private int[] array;
    private final List<Integer> ints = new ArrayList<>();
    private final StringBuilder answer = new StringBuilder();
    public String solve(String input) {
        String[] s = input.split("\n");
        length = Integer.parseInt(s[0].split(" ")[1]);
        array = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).distinct().sorted().toArray();
        bfs(0, 0);
        return answer.substring(0, answer.length() - 1);
    }

    private void bfs(int currentLength, int index) {
        if (length == currentLength) {
            String now = ints.stream().map(String::valueOf).collect(Collectors.joining(" "));
            answer.append(now).append("\n");
            return;
        }

        for (int i = index; i < array.length; i++) {
            ints.add(array[i]);
            bfs(currentLength + 1, i);
            ints.remove(ints.size() - 1);
        }
    }
}
