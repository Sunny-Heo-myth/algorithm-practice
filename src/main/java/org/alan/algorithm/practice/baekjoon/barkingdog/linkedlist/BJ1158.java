package org.alan.algorithm.practice.baekjoon.barkingdog.linkedlist;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1158 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int count = Integer.parseInt(s[1]);
        Deque<Integer> deque = new ArrayDeque<>();
        IntStream.rangeClosed(1, Integer.parseInt(s[0])).forEach(deque::add);
        List<Integer> answer = new ArrayList<>();
        while (!deque.isEmpty()) {
            for (int i = 0; i < count - 1; i++) {
                deque.addLast(deque.poll());
            }
            answer.add(deque.poll());
        }
        return "<" + answer.stream().map(String::valueOf).collect(Collectors.joining(", ")) + ">";
    }
}
