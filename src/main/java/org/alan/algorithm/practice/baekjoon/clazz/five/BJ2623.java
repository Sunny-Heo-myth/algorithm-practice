package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ2623 {
    public String solve(String input) {
        int N = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i <= N; i++) adjacency.add(new ArrayList<>());

        int[] inDegree = new int[N + 1];
        Pattern.compile("\n").splitAsStream(input).skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).skip(1).mapToInt(Integer::parseInt).toArray()).forEach(ints -> {
                    for (int i = 1; i < ints.length; i++) {
                        adjacency.get(ints[i - 1]).add(ints[i]);
                        inDegree[ints[i]]++;
                    }
        });

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < adjacency.size(); i++) if (inDegree[i] == 0) queue.offer(i);
        while (!queue.isEmpty()) {
            Integer prior = queue.poll();
            answer.add(prior);

            for (Integer next : adjacency.get(prior)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        return Arrays.stream(inDegree).filter(i -> i != 0).findFirst().stream().findAny().isEmpty() ?
                answer.stream().map(String::valueOf).collect(Collectors.joining("\n")) : "0";
    }
}
