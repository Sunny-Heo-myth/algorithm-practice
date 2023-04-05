package org.alan.algorithm.practice.programmers.overtimeindex;

import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeIndex3 {

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            overtime.offer(work);
        }

        for (int i = 0; i < n; i++) {
            assert overtime.peek() != null;
            int max = overtime.poll();
            if (max <= 0) {
                break;
            }
            overtime.offer(max - 1);
        }

        return squareSum(overtime);
    }

    private long squareSum(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty()) {
            sum += Math.pow(works.poll(), 2);
        }
        return sum;
    }
}
