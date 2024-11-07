package org.alan.algorithm.practice.baekjoon.problem;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ11003 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int L = Integer.parseInt(lines[0].split(" ")[1]);
        Queue<Integer> queue = Pattern.compile(" ").splitAsStream(lines[1])
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> pipe = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            pipe.offer(polled);
            pq.offer(polled);

            if (!pipe.isEmpty() && pipe.size() > L) {
                int poll = pipe.poll();
                pq.remove(poll);
            }

            answer.add(pq.peek());
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public String solve2(String input) {
        String[] lines = input.split("\n");
        int L = Integer.parseInt(lines[0].split(" ")[1]);
        int[] array = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        List<Integer> answer = new ArrayList<>();
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            while (!deque.isEmpty() && deque.peekLast()[0] > n) deque.pollLast();

            deque.offer(new int[]{n, i});
            if (deque.peek()[1] < i - (L - 1)) deque.poll();
            answer.add(deque.peek()[0]);
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
