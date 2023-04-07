package org.alan.algorithm.practice.programmers.doublepriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue2 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reversedPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (String s : operations) {
            String[] ss = s.split(" ");
            char operation = ss[0].charAt(0);
            int value = Integer.parseInt(ss[1]);

            if (operation == 'I') {
                priorityQueue.offer(value);
                reversedPriorityQueue.offer(value);

            } else {
                if (value == 1) {
                    extracted(reversedPriorityQueue, priorityQueue);
                } else {
                    extracted(priorityQueue, reversedPriorityQueue);
                }
            }
        }

        if (priorityQueue.isEmpty() || reversedPriorityQueue.isEmpty()) {
            return new int[]{0,0};
        } else {
            return new int[]{reversedPriorityQueue.poll(), priorityQueue.poll()};
        }
    }

    private void extracted(PriorityQueue<Integer> queue, PriorityQueue<Integer> otherQueue) {
        if (!queue.isEmpty()) {
            int i = queue.peek();
            queue.poll();
            otherQueue.remove(i);
        }
    }

}
