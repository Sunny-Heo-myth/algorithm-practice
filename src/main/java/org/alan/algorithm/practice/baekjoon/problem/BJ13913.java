package org.alan.algorithm.practice.baekjoon.problem;

import java.io.*;
import java.util.*;

// The path can be earned from footprint array.
public class BJ13913 {
    private static final int[] parents = new int[100001];
    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]), K = Integer.parseInt(line[1]);
            if (N == K) {
                bw.write("0\n" + N);
                bw.flush();
                return;
            }
            Arrays.fill(parents, -1);

            queue.offer(N);
            while (!queue.isEmpty()) {
                int x = queue.poll();

                if (x == K) {
                    Deque<Integer> answer = new ArrayDeque<>(List.of(x));
                    while (parents[x] != N) {
                        int parent = parents[x];
                        answer.offerFirst(parent);
                        x = parent;
                    }
                    answer.offerFirst(N);

                    bw.write((answer.size() - 1) + "\n");
                    while (!answer.isEmpty()) bw.write(answer.pollFirst() + " ");
                    bw.flush();
                }

                go(x - 1, x);
                go(x + 1, x);
                go(x * 2, x);
            }
        }
    }

    private static void go(int nx, int x) {
        if (nx < 0 || nx > 100000 || parents[nx] != -1) return;
        parents[nx] = x;
        queue.offer(nx);
    }

}
