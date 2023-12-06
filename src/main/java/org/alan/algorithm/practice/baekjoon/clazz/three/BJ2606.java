package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2606 {
    private boolean[] visited;  // SC: O(N)
    private boolean[][] edges;  // SC: O(N**2)
    private int count = 0;

    public static void main(String[] args) throws IOException {
        BJ2606 instance = new BJ2606();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNodes = Integer.parseInt(br.readLine());
        int numberOfEdges = Integer.parseInt(br.readLine());
        instance.visited = new boolean[numberOfNodes + 1]; // index refers node number
        instance.edges = new boolean[numberOfNodes + 1][numberOfNodes + 1];

        if (numberOfEdges == 0) {
            System.out.print(0);
            System.exit(0);
        }

        for (int i = 0; i < numberOfEdges; i++) {   // O(Edge)
            StringTokenizer str = new StringTokenizer(br.readLine());

            int end1 = Integer.parseInt(str.nextToken());
            int end2 = Integer.parseInt(str.nextToken());
            instance.edges[end1][end2] = true;
            instance.edges[end2][end1] = true;
        }

        br.close();

        instance.dfs(1);

        System.out.print(instance.count - 1);
    }

    private void dfs(int from) {
        visited[from] = true;
        count++;
        for (int to = 0; to < visited.length; to++) {
            if (edges[from][to] && !visited[to]) {
                dfs(to);
            }
        }
    }

}
