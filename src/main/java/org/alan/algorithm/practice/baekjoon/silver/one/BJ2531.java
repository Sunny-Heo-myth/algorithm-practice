package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ2531 {
    private Queue<Integer> queue;
    private int[] kinds;
    private Queue<Integer> eat;

    public String solve(String input) {
        int[] in = Pattern.compile(" ").splitAsStream(input.split("\n")[0]).mapToInt(Integer::parseInt).toArray();
        int N = in[0]; int d = in[1]; int k = in[2]; int c = in[3];

        queue = input.lines().skip(1).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        kinds = new int[d + 1];
        eat = new LinkedList<>();

        int max = 0;
        for (int i = 0; i < k; i++) max = update(max);
        if (kinds[c] == 0 && queue.peek() == c) max++;

        int cMax = max;
         for (int i = 0; i < N; i++) {
            cMax = update(cMax);
            if (--kinds[eat.poll()] == 0) cMax--;
            max = Math.max(max, kinds[c] == 0 ? cMax + 1 : cMax);
        }

        return String.valueOf(max);
    }

    private int update(int cMax) {
        int dish = queue.poll();
        eat.offer(dish);
        if (kinds[dish] == 0) cMax++;
        kinds[dish]++;
        queue.offer(dish);
        return cMax;
    }

}
