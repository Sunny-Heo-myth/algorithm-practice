package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1021 {
    public String solve(String input) {
        String[] line = input.split("\n");
        Deque<Integer> deque = IntStream.rangeClosed(1, Integer.parseInt(line[0].split(" ")[0]))
                .boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int count = 0;
        int[] pollableArray = Pattern.compile(" ").splitAsStream(line[1]).mapToInt(Integer::parseInt).toArray();
        for (int polled : pollableArray) {
            Stack<Integer> stack = new Stack<>();

            int countFirst = 0;
            while (deque.peekFirst() != polled) {
                countFirst++;
                stack.push(deque.pollFirst());
            }
            while (!stack.isEmpty()) {
                deque.addFirst(stack.pop());
            }

            int countLast = 1;
            while (deque.peekLast() != polled) {
                countLast++;
                stack.push(deque.pollLast());
            }
            while (!stack.isEmpty()) {
                deque.addLast(stack.pop());
            }

            if (countFirst <= countLast) {
                count += countFirst;
                for (int i = 0; i < countFirst; i++) deque.addLast(deque.pollFirst());
                deque.pollFirst();
            } else {
                count += countLast;
                for (int i = 0; i < countLast; i++) deque.addFirst(deque.pollLast());
                deque.pollFirst();
            }
        }

        return String.valueOf(count);
    }

}
