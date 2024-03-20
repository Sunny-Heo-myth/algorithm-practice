package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ15656 {
    private int answerLength;
    private int[] sortedArray;
    private final Stack<Integer> idxStack = new Stack<>();
    private final List<String> answer = new ArrayList<>();

    public String solve(String input) {
        String[] lineArray = input.split("\n");
        answerLength = Integer.parseInt(lineArray[0].split(" ")[1]);
        sortedArray = Pattern.compile(" ").splitAsStream(lineArray[1]).mapToInt(Integer::parseInt).sorted().toArray();
        
        recur();

        return String.join("\n", answer);
    }

    private void recur() {
        if (idxStack.size() == answerLength) {
            answer.add(idxStack.stream().map(i -> String.valueOf(sortedArray[i])).collect(Collectors.joining(" ")));
            return;
        }

        for (int i = 0; i < sortedArray.length; i++) {
            idxStack.push(i);
            recur();
            idxStack.pop();
        }
    }
}
