package programmers.longestNode;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers49189_4 {

    public static void main(String[] args) {
        int[][] ints = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int[][] ints2 = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {3, 6}, {3, 8}, {4, 8}, {5, 7}, {6, 7}, {7, 8}};
        System.out.print(solution(8, ints2));
    }

    public static int solution(int n, int[][] edge) {

        // checked status for each node
        boolean[] check = new boolean[n];
        boolean[][] map = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < edge.length; i++) {
            // mapping n*n boolean connection status
            map[edge[i][0] - 1][edge[i][1] - 1] = true;
            map[edge[i][1] - 1][edge[i][0] - 1] = true;
        }

        // Check 1st node
        check[0] = true;
        // add 1st node into queue.
        queue.add(0);
        int answer = 0;

        while (!queue.isEmpty()) {
            Integer queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int node = queue.poll();
                for (int nextNode = 0; nextNode < n; nextNode++) {
                    // if It is connected && unchecked yet
                    if (map[nextNode][node] && !check[nextNode]) {
                        // check new node
                        check[nextNode] = true;
                        // add to queue
                        queue.add(nextNode);
                    }
                }
            }
            // In queue,
            // things left in queue is same with the number of
            // the number of the furthest node from start.
            answer = queueSize;
        }
        return answer;
    }
}
