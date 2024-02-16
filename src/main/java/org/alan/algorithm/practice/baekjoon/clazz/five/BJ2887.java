package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ2887 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] planetArray = new int[n][4];
        for (int i = 0; i < n; i++) planetArray[i] = Pattern.compile(" ").splitAsStream(i + " " + bf.readLine()).mapToInt(Integer::parseInt).toArray();
        parent = IntStream.range(0, planetArray.length).toArray();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
        for (int d = 1; d <= 3; d++) {
            int dimension = d;
            Arrays.sort(planetArray, Comparator.comparingInt(planet -> planet[dimension]));
            for (int j = 1; j < planetArray.length; j++) {
                int[] planet1 = planetArray[j];
                int[] planet2 = planetArray[j - 1];
                int distance = Math.abs(planet1[dimension] - planet2[dimension]);
                pq.offer(new int[]{planet1[0], planet2[0], distance});
            }
        }

        int total = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int parent1 = find(edge[1]);
            int parent2 = find(edge[0]);

            if (parent1 != parent2) {
                total += edge[2];
                union(edge[1], edge[0]);
            }
        }
        System.out.print(total);
    }

    private static int find(int child) {
        if (parent[child] == child) return child;
        return parent[child] = find(parent[child]);
    }

    private static void union(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);

        if (parent1 < parent2) {
            int temp = parent1;
            parent1 = parent2;
            parent2 = temp;
        }

        parent[parent2] = parent1;
    }
}
