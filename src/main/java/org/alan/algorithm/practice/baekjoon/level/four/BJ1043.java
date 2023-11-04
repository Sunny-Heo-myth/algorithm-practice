package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1043 {
    private int[] graph;
    private boolean[] peopleWhoKnows;

    public String solve(String input) {
        String[] s = input.split("\n");
        String[] firstLine = s[0].split(" ");
        int numberOfPeople = Integer.parseInt(firstLine[0]);
        int numberOfParty = Integer.parseInt(firstLine[1]);

        // If there is no one who knows the truth, then he can lie to every party.
        if (s[1].equals("0")) return String.valueOf(numberOfParty);

        graph = IntStream.range(0, numberOfPeople + 1).toArray();
        peopleWhoKnows = new boolean[numberOfPeople + 1];
        Arrays.stream(s[1].split(" ")).skip(1).mapToInt(Integer::parseInt).forEach(i -> peopleWhoKnows[i] = true);

        List<List<Integer>> parties = IntStream.range(0, numberOfParty).mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toList());

        for (int n = 0; n < numberOfParty; n++) {
            String[] partyMembers = s[n + 2].split(" ");
            List<Integer> party = parties.get(n);

            party.addAll(Arrays.stream(partyMembers).skip(1).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
            for (int member = 1; member < Integer.parseInt(partyMembers[0]); member++) union(party.get(member), party.get(member - 1));
        }

        boolean[] visited = new boolean[numberOfPeople + 1];
        for (int i = 1; i <= numberOfPeople; i++) if (peopleWhoKnows[i] && !visited[i])
            for (int j = 1; j <= numberOfPeople; j++) if (i == j || find(i) == find(j)) {
                peopleWhoKnows[j] = true;
                visited[j] = true;
            }

        boolean[] canLie = new boolean[numberOfParty];
        Arrays.fill(canLie, true);
        for (int party = 0; party < numberOfParty; party++) for (int people = 1; people < numberOfPeople + 1; people++)
            if (peopleWhoKnows[people] && parties.get(party).contains(people)) {
                canLie[party] = false;
                break;
            }

        int sum = 0;
        for (int i = 0; i < numberOfParty; i++) if (canLie[i]) sum++;
        return String.valueOf(sum);
    }

    private int find(int idx) {
        if (graph[idx] == idx) return idx;
        return find(graph[idx]);
    }

    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) graph[root2] = root1;
    }
}
