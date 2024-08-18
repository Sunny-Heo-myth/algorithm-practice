package org.alan.algorithm.practice.baekjoon.gold.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class BJ1655 {
    public String solve(String input) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> firstH = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> secondH = new PriorityQueue<>();

        for (int line : input.lines().skip(1).mapToInt(Integer::parseInt).toArray()) {
            if (firstH.size() == secondH.size()) {
                firstH.offer(line);
                if (!secondH.isEmpty() && firstH.peek() > secondH.peek()) {
                    secondH.offer(firstH.poll());
                    firstH.offer(secondH.poll());
                }
            } else {
                secondH.offer(line);
                if (firstH.peek() > secondH.peek()) {
                    secondH.offer(firstH.poll());
                    firstH.offer(secondH.poll());
                }
            }
            answer.add(firstH.peek());
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
