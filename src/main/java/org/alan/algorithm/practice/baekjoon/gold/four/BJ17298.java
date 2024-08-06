package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ17298 {

    public String solve(String input) {
        int[] seq = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[seq.length]; Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < seq.length; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) answer[stack.pop()] = seq[i];
            stack.push(i);
        }

        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
