package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ2531 {
    public String solve(String input) {
        int[] in = Pattern.compile(" ").splitAsStream(input.split("\n")[0]).mapToInt(Integer::parseInt).toArray();
        int N = in[0]; int d = in[1]; int k = in[2]; int c = in[3];

        Queue<Integer> queue = input.lines().skip(1).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        int[] kinds = new int[d + 1];
        Queue<Integer> eat = new LinkedList<>();

        int max = 0;
        for (int i = 0; i < k; i++) {
            int dish = queue.poll();
            eat.offer(dish);
            if (kinds[dish] == 0) {
                max++;
                kinds[dish] = 1;
            } else {
                kinds[dish]++;
            }
            queue.offer(dish);
        }
        if (queue.peek() == c) {
            max++;
        }

        for (int i = 0; i < N; i++) {
            int currentMax = max;

            int dish = queue.poll();
            eat.offer(dish);
            if (kinds[dish] == 0) {
                currentMax++;
                kinds[dish] = 1;
            } else {
                kinds[dish]++;
            }
            queue.offer(dish);

            int polled = eat.poll();
            if (--kinds[polled] == 0) {
                currentMax--;
            }

            if (polled == c) {
                currentMax++;
            }
            if (queue.peek() == c) {
                currentMax++;
            }

            max = Math.max(currentMax, max);
        }

        return String.valueOf(max);
    }

}
