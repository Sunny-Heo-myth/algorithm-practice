package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ30805 {
    private int[] arr1;
    private int[] arr2;

    public String solve(String input) {
        String[] lines = input.split("\n");
        arr1 = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        arr2 = Pattern.compile(" ").splitAsStream(lines[3]).mapToInt(Integer::parseInt).toArray();
        int i1 = 0; int i2 = 0; List<Integer> answer = new ArrayList<>();
        while (i1 < arr1.length && i2 < arr2.length) {
            int[] maxAndIdx = findCommonMax(i1, i2);
            if (maxAndIdx[2] != 0) {
                i1 = maxAndIdx[0] + 1; i2 = maxAndIdx[1] + 1; answer.add(maxAndIdx[2]);
            } else break;
        }
        return answer.isEmpty() ? "0" : answer.size() + "\n" + answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private int[] findCommonMax(int from1, int from2) {
        PriorityQueue<int[]> pq1 = IntStream.range(from1, arr1.length).mapToObj(i -> new int[]{i, arr1[i]}).collect(Collectors.toCollection(
                () -> new PriorityQueue<>((ints1, ints2) -> ints1[1] != ints2[1] ? ints2[1] - ints1[1] : ints1[0] - ints2[0])));
        PriorityQueue<int[]> pq2 = IntStream.range(from2, arr2.length).mapToObj(i -> new int[]{i, arr2[i]}).collect(Collectors.toCollection(
                () -> new PriorityQueue<>((ints1, ints2) -> ints1[1] != ints2[1] ? ints2[1] - ints1[1] : ints1[0] - ints2[0])));
        while (!pq1.isEmpty() && !pq2.isEmpty()) {
            if (pq1.peek()[1] > pq2.peek()[1]) pq1.poll();
            else if (pq1.peek()[1] < pq2.peek()[1]) pq2.poll();
            else return new int[] {pq1.peek()[0], pq2.peek()[0], pq1.peek()[1]};
        }
        return new int[]{0, 0, 0};
    }
}
