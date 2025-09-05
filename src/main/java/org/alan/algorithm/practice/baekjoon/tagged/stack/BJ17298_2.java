package org.alan.algorithm.practice.baekjoon.tagged.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ17298_2 {
    private final int[] arr;
    private final Stack<Integer> stack = new Stack<>();

    public BJ17298_2(String input) {
        arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        List<Integer> answer = new ArrayList<>(arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            answer.add(stack.isEmpty() ? -1 : arr[stack.peek()]);
            stack.push(i);
        }

        Collections.reverse(answer);
        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
