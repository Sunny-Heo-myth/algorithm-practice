package org.alan.algorithm.practice.baekjoon.level.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1865 {
    private int numberOfVertix;
    private final List<int[]> edges = new ArrayList<>(); // stateless

    public String solve(BufferedReader br) throws IOException {
        parse(br);
        return bellmanFord() ? "YES" : "NO";
    }

    private void parse(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numberOfVertix = Integer.parseInt(st.nextToken());
        int numberOfRoad = Integer.parseInt(st.nextToken());
        int numberOfWarmHole = Integer.parseInt(st.nextToken());

        for (int i = 0; i < numberOfRoad + numberOfWarmHole; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (i < numberOfRoad) {
                edges.add(new int[]{from, to, cost});
                edges.add(new int[]{to, from, cost});
            } else {
                edges.add(new int[]{from, to, -cost});
            }
        }
    }

    private boolean bellmanFord() {
        int noRoute = Integer.MAX_VALUE - 10000;
        int[] distance = new int[numberOfVertix + 1];
        Arrays.fill(distance, noRoute);
        distance[1] = 0;

        for (int i = 1; i < numberOfVertix; i++) for (int[] edge : edges)
                distance[edge[1]] = Integer.min(distance[edge[0]] + edge[2], distance[edge[1]]);

        for (int[] edge : edges) if (distance[edge[0]] + edge[2] < distance[edge[1]]) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfQuestions = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (numberOfQuestions-- > 0) sb.append(new BJ1865().solve(br)).append("\n");
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
