package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ16566 {
    private int[] cards;
    private int[] memo;

    public String solve(String input) {
        int[][] inputArr = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        cards = Arrays.stream(inputArr[1]).sorted().toArray();
        memo = IntStream.range(0, cards.length).toArray();

        List<String> answer = new ArrayList<>();
        for (int draw : inputArr[2]) {

            int left = 0, right = memo.length - 1;
            while (left < right) {
                int mid = (right + left) / 2;
                if (cards[mid] > draw) right = mid;
                else if (cards[mid] <= draw) left = mid + 1;
                else break;
            }

            if (cards[left] > draw) {
                answer.add(String.valueOf(cards[find(left)]));
                merge(find(left), find(left) + 1);
            } else {
                answer.add(String.valueOf(cards[left + 1]));
                merge(find(left + 1), find(left + 1) + 1);
            }
        }
        return String.join("\n", answer);
    }

    private int find(int child) {
        if (memo[child] == child) return child;
        return memo[child] = find(memo[child]);
    }

    private void merge(int small, int big) {
        if (big >= memo.length) return;
        int smallP = find(small), bigP = find(big);
        if (cards[smallP] != cards[bigP]) memo[smallP] = bigP;
    }

}
