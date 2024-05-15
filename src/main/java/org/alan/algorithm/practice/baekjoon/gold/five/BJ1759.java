package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ1759 {
    private int l;
    private int[] chars;
    private boolean[] visited;
    private final List<Integer> current = new ArrayList<>();
    private final List<String> answer = new ArrayList<>();
    private static final int[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public String solve(String input) {
        String[] lines = input.split("\n");
        l = Integer.parseInt(lines[0].split(" ")[0]);
        chars = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(s -> s.charAt(0)).sorted().toArray();
        visited = new boolean[chars.length];
        recur(0);
        return String.join("\n", answer);
    }

    private void recur(int nth) {
        if (current.size() == l) {
            if (current.stream().anyMatch(i -> Arrays.stream(VOWELS).anyMatch(j -> chars[i] == j))
                    && current.stream().filter(i -> Arrays.stream(VOWELS).noneMatch(j -> chars[i] == j)).count() >= 2) {
                answer.add(current.stream().map(i -> String.valueOf((char) chars[i])).collect(Collectors.joining()));
            }
            return;
        }

        for (int i = nth; i < chars.length; i++) {
            if (visited[i]) continue;
            current.add(i);
            visited[i] = true;
            recur(i + 1);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
