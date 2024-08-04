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
        int moneyLeft = lines[2][0];

        int first = IntStream.range(1, costs.length).boxed().min(Comparator.comparingInt(i -> costs[i])).orElse(-1);
        int min = IntStream.range(0, costs.length).boxed().min(Comparator.comparingInt(i -> costs[i])).orElse(-1);
        int numberOfCard = 1 + (moneyLeft - costs[first]) / costs[min];
        if (numberOfCard <= 0) return "0";

        int[] answer = new int[numberOfCard];
        answer[0] = first;
        for (int i = 1; i < answer.length; i++) answer[i] = min;
        moneyLeft -= (costs[first] + (numberOfCard - 1) * costs[min]);

        for (int i = 0; i < answer.length; i++) {
            int old = answer[i];
            for (int j = costs.length - 1; j >= 0; j--) if ((costs[j] - costs[old]) <= moneyLeft) {
                answer[i] = j;
                break;
            }
            if (old == answer[i]) return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining());
            moneyLeft -= (costs[answer[i]] - costs[old]);
        }

        return Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
