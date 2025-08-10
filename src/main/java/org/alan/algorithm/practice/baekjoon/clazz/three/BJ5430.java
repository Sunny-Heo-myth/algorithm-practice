package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ5430 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        String operations = lines[0];
        String s = lines[2].substring(1, lines[2].length() - 1);

        Deque<Integer> deque = s.isEmpty() ? new ArrayDeque<>()
                : Pattern.compile(",").splitAsStream(s)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        boolean fromFirst = true;
        for (char operation : operations.toCharArray()) {
            if (operation == 'R') {
                fromFirst = !fromFirst;
                continue;
            }

            if (deque.isEmpty()) return "error";

            if (fromFirst) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
        }

        List<Integer> answer = new ArrayList<>();
        while (!deque.isEmpty()) {
            if (fromFirst) {
                answer.add(deque.removeFirst());
            } else {
                answer.add(deque.removeLast());
            }
        }
        return "[" + answer.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }
}
