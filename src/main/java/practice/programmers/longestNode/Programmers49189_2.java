package practice.programmers.longestNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Programmers49189_2 {

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] edge) {

        Arrays.stream(edge)
            .forEach(line -> {
                int temp;
                if (line[0] > line[1]) {
                    temp = line[1];
                    line[1] = line[0];
                    line[0] = temp;
                }
            });

        boolean[][] booleans = new boolean[n][n];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int end = 2; end <= n; end++) {
            Arrays.stream(edge)
                .forEach(line -> {
                    booleans[line[0] - 1][line[1] - 1] = true;
                });
            int minCount = Integer.MAX_VALUE;
            Stack<int[]> stack = new Stack<>();
            for (int[] line : edge) {
                if (line[0] == 1) {
                    stack.push(line);
                }
            }
            while (!stack.isEmpty()) {
                int[] nowLine = stack.pop();

            }


        }
        return 0;
    }
}
