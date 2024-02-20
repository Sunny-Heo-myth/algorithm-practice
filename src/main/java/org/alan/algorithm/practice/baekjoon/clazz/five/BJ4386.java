package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ4386 {
    private int[] parentArray;

    public String solve(String input) {
        double[][] stars = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToDouble(Double::parseDouble).toArray()).toArray(double[][]::new);

        parentArray = IntStream.range(0, stars.length).toArray();

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(node -> node.distance));
        for (int i = 0; i < stars.length; i++) for (int j = i + 1; j < stars.length; j++) pq.offer(new Edge(i, j, getDistance(stars[i], stars[j])));

        double total = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            int parent1 = find(e.star1);
            int parent2 = find(e.star2);

            if (parent1 != parent2) {
                total += e.distance;
                union(parent1, parent2);
            }
        }
        return String.valueOf(total);
    }

    private int find(int child) {
        if (parentArray[child] == child) return child;
        return parentArray[child] = find(parentArray[child]);
    }

    private void union(int child1, int child2) {
        int parent1 = find(child1);
        int parent2 = find(child2);
        parentArray[Math.min(parent1, parent2)] = Math.max(parent1, parent2);
    }


    private double getDistance(double[] star1, double[] star2) {
        double distance1 = Math.abs(star1[0] - star2[0]);
        double distance2 = Math.abs(star1[1] - star2[1]);
        return Math.sqrt(distance1 * distance1 + distance2 * distance2);
    }

    private class Edge {
        int star1;
        int star2;
        double distance;

        Edge(int star1, int star2, double distance) {
            this.star1 = star1;
            this.star2 = star2;
            this.distance = distance;
        }
    }
}
