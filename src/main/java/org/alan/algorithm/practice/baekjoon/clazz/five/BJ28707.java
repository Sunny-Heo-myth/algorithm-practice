package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.*;
import java.util.regex.Pattern;

public class BJ28707 {

    public String solve(String input) {
        int[] init = input.lines().skip(1).findFirst().stream().flatMapToInt(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        CArray sorted = new CArray(Arrays.stream(init).sorted().toArray());
        int[][] ops = input.lines().skip(3).map(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        Map<CArray, Integer> map = new HashMap<>();
        PriorityQueue<CArray> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        CArray initKey = new CArray(init);
        map.put(initKey, 0);
        pq.offer(initKey);
        while (!pq.isEmpty()) {
            CArray popped = pq.poll();
            if (popped.equals(sorted)) return String.valueOf(map.get(popped));
            for (int[] op: ops) {
                int[] copy = Arrays.copyOf(popped.value, popped.value.length);
                int temp = copy[op[0] - 1];
                copy[op[0] - 1] = copy[op[1] - 1];
                copy[op[1] - 1] = temp;
                CArray newCA = new CArray(copy);
                if (map.containsKey(newCA) && map.get(newCA) <= map.get(popped) + op[2]) continue;
                map.put(newCA, map.get(popped) + op[2]);
                pq.offer(newCA);
            }
        }
        return "-1";
    }

    private static class CArray {
        private final int[] value;

        public CArray(int[] value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CArray)) return false;
            return Arrays.equals(value, ((CArray) o).value);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(value);
        }
    }
}
