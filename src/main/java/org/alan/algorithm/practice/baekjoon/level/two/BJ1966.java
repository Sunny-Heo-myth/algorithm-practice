package org.alan.algorithm.practice.baekjoon.level.two;

import java.util.LinkedList;
import java.util.Queue;

public class BJ1966 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        int target = Integer.parseInt(lines[0].split(" ")[1]);
        String[] second = lines[1].split(" ");
        Queue<Printable> queue = new LinkedList<>();
        int[] scores = new int[10];
        for (int i = 0; i < second.length; i++) {
            int score = Integer.parseInt(second[i]);
            scores[score]++;
            queue.offer(new Printable(i, score));
        }

        int count = 0;
        outer:
        while (!queue.isEmpty()) {
            Printable p = queue.peek();

            for (int score = p.score + 1; score < scores.length; score++) {
                if (scores[score] != 0) {
                    queue.offer(queue.poll());
                    continue outer;
                }
            }

            p = queue.poll();
            count++;
            if (p.order == target) return String.valueOf(count);
            scores[p.score]--;
        }

        return String.valueOf(second.length);
    }

    private static class Printable {
        private int order;
        private int score;

        public Printable(int order, int score) {
            this.order = order;
            this.score = score;
        }
    }
}
