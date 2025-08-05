package org.alan.algorithm.practice.baekjoon.clazz.two;

import java.util.*;
import java.util.stream.Collectors;

public class BJ10845 {

    public String solve(String input) {
        List<String> ops = input.lines().skip(1).collect(Collectors.toList());
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for (String op : ops) {
            if (op.startsWith("push ")) {
                deque.offer(Integer.parseInt(op.substring(5)));
            } else {
                switch (op) {
                    case "front": answer.add(deque.isEmpty() ? -1 : deque.getFirst()); break;
                    case "back": answer.add(deque.isEmpty() ? -1 : deque.getLast()); break;
                    case "size": answer.add(deque.size()); break;
                    case "empty": answer.add(deque.isEmpty() ? 1 : 0); break;
                    case "pop": answer.add(deque.isEmpty() ? -1 : deque.removeFirst()); break;
                    default: throw new IllegalArgumentException();
                }
            }
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }

}
