package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ30014 {
    public String solve(String input) {
        int[] pearls = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .mapToInt(Integer::parseInt)
                .sorted().toArray();

        Deque<Integer> deque = new ArrayDeque<>();
        boolean fromFirst = true;
        for (int value : pearls) {
            if (fromFirst) deque.offerFirst(value);
            else deque.offerLast(value);
            fromFirst = !fromFirst;
        }

        int sum = 0, i = 0, size = deque.size();
        while (i++ < size) {
            int first = deque.pollFirst(), second = deque.peekFirst();
            deque.offerLast(first);
            sum += (first * second);
        }
        return sum + "\n" + deque.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
