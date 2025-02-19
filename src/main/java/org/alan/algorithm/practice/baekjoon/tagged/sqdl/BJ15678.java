package org.alan.algorithm.practice.baekjoon.tagged.sqdl;

import java.util.*;
import java.util.regex.Pattern;

public class BJ15678 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        int JUMP = Integer.parseInt(lines[0].split(" ")[1]);
        int[] STONES = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        long ans = Long.MIN_VALUE;
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < STONES.length; i++) {
            while (!deque.isEmpty() && deque.peekLast().idx + JUMP < i) deque.pollLast();

            if (deque.isEmpty()) {
                deque.offerLast(new Node(i, STONES[i]));
                continue;
            }

            long sum = deque.peekLast().sum + STONES[i];    //STONES[i]가 0 이상이라면 최댓값 갱신
            if (deque.peekLast().sum <= sum) {
                deque.offerLast(new Node(i, sum));
            } else {    // 아니면 sum(현재 최댓값 + STONES[i])보다 작은 최댓값 제거 및 추가
                while (deque.size() > 1 && deque.peekFirst().sum <= sum) deque.pollFirst();
                deque.offerFirst(new Node(i, sum));
            }

            if (deque.peekLast().sum <= STONES[i]) deque.offerLast(new Node(i, STONES[i]));   //STONES[i]가 최댓값인 경우 최댓값 갱신
            ans = Math.max(ans, deque.peekLast().sum);
        }
        return String.valueOf(ans);
    }

    static class Node {
        int idx;
        long sum;

        public Node(int idx, long sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }
    
}
