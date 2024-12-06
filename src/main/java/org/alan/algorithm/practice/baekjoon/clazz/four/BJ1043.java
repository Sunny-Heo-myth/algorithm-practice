package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1043 {
    private int[] graph;

    public String solve(String input) {
        String[] s = input.split("\n");
        StringTokenizer st = new StringTokenizer(s[0]);
        int numberOfPeople = Integer.parseInt(st.nextToken());
        int numberOfParty = Integer.parseInt(st.nextToken());
        if (s[1].equals("0")) return String.valueOf(numberOfParty);

        graph = IntStream.range(0, numberOfPeople + 1).toArray();

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < numberOfParty; i++) {
            parties.add(Arrays.stream(s[i + 2].split(" ")).skip(1).map(Integer::parseInt).collect(Collectors.toList()));
            List<Integer> party = parties.get(i);
            IntStream.range(1, party.size()).forEach(j -> union(party.get(j), party.get(j - 1)));
        }

        boolean[] visited = new boolean[numberOfPeople + 1];
        boolean[] peopleWhoKnow = new boolean[numberOfPeople + 1];
        Arrays.stream(s[1].split(" ")).skip(1).mapToInt(Integer::parseInt).forEach(i -> peopleWhoKnow[i] = true);

        IntStream.range(1, numberOfPeople + 1)
                .filter(i -> peopleWhoKnow[i] && !visited[i])
                .forEach(i -> IntStream.range(1, numberOfPeople + 1)
                        .filter(j -> i == j || find(i) == find(j))
                        .forEach(j -> {
                            visited[j] = true;
                            peopleWhoKnow[j] = true;
                        }));

        boolean[] canLie = new boolean[numberOfParty];
        Arrays.fill(canLie, true);
        for (int party = 0; party < numberOfParty; party++) for (int people = 1; people < numberOfPeople + 1; people++)
            if (peopleWhoKnow[people] && parties.get(party).contains(people)) {
                canLie[party] = false;
                break;
            }

        int sum = 0;
        for (boolean b : canLie) if (b) sum++;
        return String.valueOf(sum);
    }

    private int find(int person) {
        if (graph[person] == person) return person;
        return find(graph[person]);
    }

    private void union(int p1, int p2) {
        int root1 = find(p1);
        int root2 = find(p2);
        if (root1 != root2) graph[root2] = root1;
    }
}
