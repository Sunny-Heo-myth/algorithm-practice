package org.alan.algorithm.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    private final int numberOfNode;
    private final int numberOfEdge;
    private final int[] fromArray;
    private final int[] toArray;

    public TopologicalSort(int numberOfNode, int[] fromArray, int[] toArray) {
        if (fromArray.length != toArray.length) {
            throw new IllegalArgumentException();
        }

        this.numberOfNode = numberOfNode;
        this.numberOfEdge = fromArray.length;
        this.fromArray = fromArray;
        this.toArray = toArray;
    }

    public Queue<Integer> solve() {
        // Outer List index is "from" node & Inner list index is list of "to" node.
        List<List<Integer>> fromTo = new ArrayList<>();
        for (int i = 0; i < numberOfNode + 1; i++) {
            fromTo.add(new ArrayList<>());
        }

        // index 0 is remain unused
        int[] inDegrees = new int[numberOfNode + 1];
        for (int i = 0; i < numberOfEdge; i++) {
            int from = fromArray[i];
            int to = toArray[i];

            fromTo.get(from).add(to);
            inDegrees[to]++;
        }

        return sort(fromTo, inDegrees);

    }

    private Queue<Integer> sort(List<List<Integer>> fromTo, int[] inDegrees) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        // There can be multiple starting point wherever inDegree is 0
        for (int i = 1; i < numberOfNode + 1; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.offer(node);

            for (int to : fromTo.get(node)) {
                inDegrees[to]--;

                if (inDegrees[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        
        return result;
    }


}
