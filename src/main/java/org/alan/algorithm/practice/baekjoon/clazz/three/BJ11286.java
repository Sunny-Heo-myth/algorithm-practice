package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class BJ11286 {
    public String solve(String input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int m = Math.abs(a);
            int n = Math.abs(b);
            if (m > n) return m - n;
            else if (m == n) return a - b;
            else return -1;
        });

        StringBuilder sb = new StringBuilder();
        Pattern.compile("\n").splitAsStream(input).skip(1).forEach(s -> {
            int i = Integer.parseInt(s);
            if (i == 0) {
                if (pq.isEmpty()) sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            }
            else pq.offer(i);
        });
        return sb.substring(0, sb.length() - 1);
    }
}
