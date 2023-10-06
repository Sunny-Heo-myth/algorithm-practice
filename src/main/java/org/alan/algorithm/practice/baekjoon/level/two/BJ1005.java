package org.alan.algorithm.practice.baekjoon.level.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class BJ1005 {

    public String solve() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder result = new StringBuilder();
        while (n > 0) {

            String[] s = bf.readLine().split(" ");
            int numberOfNodes = Integer.parseInt(s[0]);
            int numberOfEdges = Integer.parseInt(s[1]);

            int[] nodes = IntStream.rangeClosed(1, numberOfNodes).toArray();
            Map<Integer, Integer> nodeCosts = new HashMap<>();
            Map<Integer, Integer> nodeTotalCosts = new HashMap<>();

            int[] costs = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < nodes.length; i++) {
                nodeCosts.put(nodes[i], costs[i]);
                nodeTotalCosts.put(nodes[i], costs[i]);
            }


            int[] froms = new int[numberOfEdges];
            int[] tos = new int[numberOfEdges];
            for (int i = 0; i < numberOfEdges; i++) {
                String[] ss = bf.readLine().split(" ");
                froms[i] = Integer.parseInt(ss[0]);
                tos[i] = Integer.parseInt(ss[1]);
            }

            int destination = Integer.parseInt(bf.readLine());

            result.append(traverse(nodes, nodeCosts, nodeTotalCosts, froms, tos, destination)).append("\n");

            n--;
        }

        bf.close();
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private String traverse(int[] nodes,
                            Map<Integer, Integer> nodeCosts,
                            Map<Integer, Integer> nodeTotalCosts,
                            int[] froms,
                            int[] tos,
                            int destination) {

        Map<Integer, List<Integer>> fromTo = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (int node : nodes) {
            fromTo.put(node, new ArrayList<>());
            inDegrees.put(node, 0);
        }

        for (int i = 0; i < froms.length; i++) {
            fromTo.get(froms[i]).add(tos[i]);
            inDegrees.put(tos[i], inDegrees.getOrDefault(tos[i], 1) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int to : inDegrees.keySet()) {
            if (inDegrees.get(to) == 0) {
                queue.offer(to);
            }
        }

        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int from = queue.poll();

            if (from == destination) {
                int sum = nodeTotalCosts.get(destination);
                if (sum < answer) {
                    answer = sum;
                }
                continue;
            }

            for (int to : fromTo.get(from)) {

                if (!Objects.equals(nodeTotalCosts.get(to), nodeCosts.get(to))) {
                    int newSum = nodeTotalCosts.get(from) + nodeCosts.get(to);
                    if (nodeTotalCosts.get(to) < newSum) {
                        nodeTotalCosts.put(to, newSum);
                    }
                } else {
                    nodeTotalCosts.put(to, nodeTotalCosts.get(to) + nodeTotalCosts.get(from));
                }

                inDegrees.put(to, inDegrees.get(to) - 1);
                if (inDegrees.get(to) == 0) {
                    queue.offer(to);
                }

            }
        }
        return String.valueOf(answer);
    }

}
