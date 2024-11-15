package org.alan.algorithm.practice.baekjoon.problem;
import java.util.LinkedList;
import java.util.Queue;

public class BJ25381 {
    public String solve(String input) {
        Queue<Integer> aQueue = new LinkedList<>();
        Queue<Integer> bQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();

        for (int i = input.length() - 1; i >= 0; i--) {
            switch (input.charAt(i)) {
                case 'A': aQueue.add(i); break;
                case 'B': bQueue.add(i); break;
                case 'C': cQueue.add(i); break;
            }
        }

        int answer = 0;
        answer = count(answer, aQueue, bQueue);
        answer = count(answer, bQueue, cQueue);
        return String.valueOf(answer);
    }

    private int count(int answer, Queue<Integer> queue1, Queue<Integer> queue2) {
        while (!queue1.isEmpty()) {
            if (queue2.isEmpty()) break;

            if (queue1.peek() < queue2.peek()) {
                queue2.poll();
                answer++;
            }
            queue1.poll();
        }
        return answer;
    }

    public String solve2(String input) {
        Queue<Integer> aq = new LinkedList<>();
        Queue<Integer> bq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();

        for (int i = input.length() - 1; i >= 0; i--) {
            switch (input.charAt(i)) {
                case 'A': aq.offer(i); break;
                case 'B': bq.offer(i); break;
                case 'C': cq.offer(i); break;
            }
        }

        int answer = 0;
        answer = count2(answer, aq, bq);
        answer = count2(answer, bq, cq);
        return String.valueOf(answer);
    }

    private int count2(int answer, Queue<Integer> q1, Queue<Integer> q2) {
        while (!q1.isEmpty()) {
            if (q2.isEmpty()) break;

            if (q1.peek() < q2.peek()) {
                q2.poll();
                answer++;
            }
            q1.poll();
        }
        return answer;
    }


}
