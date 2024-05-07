package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ13335 {

    public String solve(String input) {
        int[][] in = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int l = in[0][1]; int w = in[0][2];

        Queue<Integer> trucks = Arrays.stream(in[1]).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> bridge =  IntStream.range(0, l).mapToObj(i -> 0).collect(Collectors.toCollection(LinkedList::new));

        int elapsed = 0;
        int cw = 0;
        while (!trucks.isEmpty()) {
            cw -= bridge.poll();

            if (trucks.peek() + cw <= w) {
                int poll = trucks.poll();
                cw += poll;
                bridge.offer(poll);
            } else {
                bridge.offer(0);
            }

            elapsed++;
        }

        return String.valueOf(elapsed + l);
    }
}
