package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ17299 {
    public String solve(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt)
                .peek(i -> map.put(i, map.getOrDefault(i, 1) + 1))
                .toArray();
        int[] answer = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(arr[stack.peek()]) <= map.get(arr[i])) stack.pop();
            answer[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            stack.push(i);
        }
        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
