package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1715 {
    public String solve(String input) {
         PriorityQueue<Long> pq = Pattern.compile("\n").splitAsStream(input).skip(1)
                 .mapToLong(Long::parseLong).boxed().collect(Collectors.toCollection(PriorityQueue::new));

         long sum = 0;
         while (pq.size() > 1) {
             long cSum = pq.poll() + pq.poll();
             sum += cSum;
             pq.offer(cSum);
         }
         return String.valueOf(sum);
    }
}
