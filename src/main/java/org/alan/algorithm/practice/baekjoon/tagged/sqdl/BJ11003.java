package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import java.util.*;
import java.util.stream.Collectors;

public class BJ11003 {
    private final int L;
    private final int[] arr;

    public BJ11003(String input) {
        String[] lines = input.split("\n");
        L = Integer.parseInt(lines[0].split(" ")[1]);
        arr = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - L + 1) deque.pollFirst();
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) deque.pollLast();
            deque.offerLast(i);
            answer.add(deque.peekFirst());
        }
        return answer.stream().map(i -> String.valueOf(arr[i])).collect(Collectors.joining(" "));
    }

}
