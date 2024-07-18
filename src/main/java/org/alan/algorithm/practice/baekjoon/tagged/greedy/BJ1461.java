package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public class BJ1461 {
    public String solve(String input) {
        int hand = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        Queue<Integer> queue = input.lines().skip(1).flatMapToInt(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt)).sorted().collect(LinkedList::new, LinkedList::add, List::addAll);

        while (!queue.isEmpty()) {
            int first = queue.poll();
            boolean negative = first < 0;

        }
        return null;
    }
}
