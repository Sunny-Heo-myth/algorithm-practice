package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ27172 {
    public String solve(String input) {
        int N = input.lines().findFirst().map(Integer::parseInt).orElse(-1);
        Iterator<Integer> iterator = IntStream.iterate(0, i -> i < N, i -> i + 1).iterator();

        Map<Integer, Integer> cardPlayerMap = new HashMap<>();
        boolean[] cards = new boolean[1000001];
        input.lines().skip(1)
                .flatMapToInt(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt))
                .forEach(i -> {
                    cardPlayerMap.put(i, iterator.next());
                    cards[i] = true;
                });

        int[] scores = new int[N];
        for (int i = 1; i <= 1000000; i++) if (cards[i]) for (int j = i * 2; j <= 1000000; j += i) if (cards[j]) {
            scores[cardPlayerMap.get(j)]--;
            scores[cardPlayerMap.get(i)]++;
        }
        return Arrays.stream(scores).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
