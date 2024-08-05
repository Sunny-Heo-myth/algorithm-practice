package org.alan.algorithm.practice.baekjoon.gold.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1082 {
    public String solve(String input) {
        int[][] lines = input.lines().map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int[] costs = lines[1];
        if (costs.length <= 1) return "0";

        int money = lines[2][0];
        int firstN = IntStream.range(1, costs.length).boxed().min(Comparator.comparingInt(i -> costs[i])).orElse(-1);
        if (costs[firstN] > money) return "0";

        int min = IntStream.range(0, costs.length).boxed().min(Comparator.comparingInt(i -> costs[i])).orElse(-1);
        int[] answer = new int[(money - costs[firstN]) / costs[min] + 1];

        answer[0] = firstN;
        money -= costs[firstN];
        for (int i = 1; i < answer.length; i++) answer[i] = min;
        money -= (money / costs[min]) * costs[min];

        for (int i = 0; i < answer.length; i++) {
            int oldN = answer[i];
            for (int newN = costs.length - 1; newN > oldN; newN--) if ((costs[newN] - costs[oldN]) <= money) {
                answer[i] = newN;
                money -= (costs[newN] - costs[oldN]);
                break;
            }
        }
        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
