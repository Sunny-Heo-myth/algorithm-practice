package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ15655 {
    private int length;
    private int[] ints;
    private final Stack<Integer> idxList = new Stack<>();
    private final List<String> answer = new ArrayList<>();

    public String solve(String input) {
        String[] lineArray = input.split("\n");
        length = Integer.parseInt(lineArray[0].split(" ")[1]);
        ints = Pattern.compile(" ").splitAsStream(lineArray[1]).mapToInt(Integer::parseInt).sorted().toArray();

        for (int i = 0; i <= ints.length - length; i++) {
            idxList.push(i);
            recur(i);
            idxList.pop();
        }

        return String.join("\n", answer);
    }

    private void recur(int i) {
        if (idxList.size() == length) {
            answer.add(idxList.stream().map(idx -> String.valueOf(ints[idx])).collect(Collectors.joining(" ")));
            return;
        }

        for (int j = i + 1; j < ints.length; j++) {
            idxList.push(j);
            recur(j);
            idxList.pop();
        }
    }
}
