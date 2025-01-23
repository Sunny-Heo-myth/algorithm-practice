package org.alan.algorithm.practice.baekjoon.barkingdog.segmenttree;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ2104 {
    private int N;
    private long[] arr, minTree, sumTree;

    public String solve(String input) {
        String[] lines = input.split("\n");
        N = Integer.parseInt(lines[0]);
        arr = Pattern.compile(" ").splitAsStream("0 " + lines[1]).mapToLong(Long::parseLong).toArray();
        minTree = new long[N * 4];
        sumTree = new long[N * 4];

        buildSumTree(1, 1, N);
        buildMinTree(1, 1, N);

        // initiation: SumTree & minTree are ready.
        // after loop: With the widest range while keeping the min value is arr[i], a multiple is calculated.
        // termination: max is calculated from each of those multiples.
        return String.valueOf(IntStream.rangeClosed(1, N)
                .filter(i -> arr[i] != 0)
                .mapToLong(i -> sum(1, 1, N, leftBoundary(i, arr[i]), rightBoundary(i, arr[i])) * arr[i])
                .max().orElse(0));
    }

    private void buildSumTree(int node, int start, int end) {
        if (start == end) {
            sumTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildSumTree(node * 2, start, mid);
        buildSumTree(node * 2 + 1, mid + 1, end);
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    private void buildMinTree(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        buildMinTree(node * 2, start, mid);
        buildMinTree(node * 2 + 1, mid + 1, end);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }

    // start & end are the current node's segment, dependent to node
    private long sum(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return sumTree[node];

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, l, r) + sum(node * 2 + 1, mid + 1, end, l, r);
    }

    // start & end are the current node's segment, dependent to node
    private long min(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Long.MAX_VALUE;
        if (l <= start && end <= r) return minTree[node];

        int mid = (start + end) / 2;
        return Math.min(min(node * 2, start, mid, l, r), min(node * 2 + 1, mid + 1, end, l, r));
    }

    // the leftmost boundary where the subarray minimum remains >= arr[i]
    private int leftBoundary(int i, long min) {
        int from = 1, low = 1, high = i;
        while (low <= high) {
            int mid = (low + high) / 2;
            long temp = min(1, 1, N, mid, i);
            if (temp >= min) {
                from = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return from;
    }

    // the rightmost boundary with subarray minimum remains >= arr[i]
    private int rightBoundary(int i, long min) {
        int to = i, low = i, high = N;
        while (low <= high) {
            int mid = (low + high) / 2;
            long temp = min(1, 1, N, i, mid);
            if (temp >= min) {
                to = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return to;
    }

}
