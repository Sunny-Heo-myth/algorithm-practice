package programmers.longestNode;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers49189 {

    public static void main(String[] args) {
        int[][] ints = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(new Solution().solution(6, ints));
    }
}

class Solution {
    public int solution(int n, int[][] edge) {

        boolean[] checked = new boolean[n];
        boolean[][] map = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        checked[0] = true;
        queue.add(0);
        for (int[] line : edge) {
            map[line[0] - 1][line[1] - 1] = true;
            map[line[1] - 1][line[0] - 1] = true;
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int from = queue.poll();
                for (int to = 0; to < n; to++) {
                    if (!checked[to] && map[to][from]) {
                        checked[to] = true;
                        queue.add(to);
                    }
                }
            }
            answer = queueSize;
        }
        return answer;
    }
}
