package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ15655 {

    public String solve(String input) {
        String[] lineArray = input.split("\n");
        int seqLength = Integer.parseInt(lineArray[0].split(" ")[1]);
        int[] ints = Pattern.compile(" ").splitAsStream(lineArray[1]).mapToInt(Integer::parseInt).sorted().toArray();
        Stack<Integer> idxStack = new Stack<>();
        List<String> answer = new ArrayList<>();
        if (ints.length > 0 && seqLength > 0) idxStack.push(-1);

        while (!idxStack.isEmpty()) {
            IntStream.range(idxStack.pop() + 1, ints.length).takeWhile(i -> idxStack.size() < seqLength).forEach(idxStack::push);

            if (idxStack.size() == seqLength) {
                answer.add(idxStack.stream().map(idx -> String.valueOf(ints[idx])).collect(Collectors.joining(" ")));
            }

            while (!idxStack.isEmpty() && idxStack.peek() >= ints.length - (seqLength - idxStack.size())) {
                idxStack.pop();
            }
        }

        return String.join("\n", answer);
    }
}
