package org.alan.algorithm.lab;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Topological sort can only be used with non-cyclical arrowed graph to sort traverse order.
 */
public class TopologicalSort {
    private final int[] nodes;
    private final int[] fromArray;
    private final int[] toArray;

    public TopologicalSort(int nodes, int[] fromArray, int[] toArray) {
        if (fromArray.length != toArray.length) {
            throw new IllegalArgumentException();
        }

        this.nodes = IntStream.rangeClosed(1, nodes).toArray();
        this.fromArray = fromArray;
        this.toArray = toArray;
    }

    public TopologicalSort(int[] nodes, int[] fromArray, int[] toArray) {
        if (fromArray.length != toArray.length) {
            throw new IllegalArgumentException();
        }

        this.nodes = nodes;
        this.fromArray = fromArray;
        this.toArray = toArray;
    }

    public Queue<Integer> solve() {
        Map<Integer, List<Integer>> fromTo = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (int i : nodes) {
            fromTo.put(i, new ArrayList<>());
            inDegrees.put(i, 0);
        }

        for (int i = 0; i < fromArray.length; i++) {
            int from = fromArray[i];
            int to = toArray[i];

            fromTo.get(from).add(to);
            if (inDegrees.containsKey(to)) {
                inDegrees.put(to, inDegrees.get(to) + 1);
            } else {
                inDegrees.put(to, 1);
            }

        }

        return sort(fromTo, inDegrees);

    }

    private Queue<Integer> sort(Map<Integer, List<Integer>> fromTo, Map<Integer, Integer> inDegrees) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        // There can be multiple starting point wherever inDegree value for the node is 0
        for (int from : fromTo.keySet()) {
            if (inDegrees.get(from) == 0) {
                queue.offer(from);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.offer(node);

            for (int to : fromTo.get(node)) {
                inDegrees.put(to, inDegrees.get(to) - 1);

                if (inDegrees.get(to) == 0) {
                    queue.offer(to);
                }
            }
        }

        return result;
    }


}
