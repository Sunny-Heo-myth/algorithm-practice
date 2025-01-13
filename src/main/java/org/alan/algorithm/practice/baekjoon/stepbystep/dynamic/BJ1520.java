package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1520 {
    private final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    private int[][] map, memo;
    
    public String solve(String input) {
        map = input.lines().skip(1).map(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);

        memo = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) Arrays.fill(memo[i], -1);
        memo[map.length - 1][map[0].length - 1] = 1;

        Stack<int[]> subProblems = new Stack<>();

        // Initiation: The number of ways from destination to itself is 1
        // after loop: loop target is properly calculated from all subProblems or all of the subProblems has been registered.
        // termination: The number of ways from (0, 0) to destination is calculated.
        subProblems.push(new int[]{0, 0});
        while (!subProblems.isEmpty()) {
            int[] problem = subProblems.pop();
            int x = problem[0], y = problem[1];
            if (memo[x][y] != -1) continue;
            subProblems.push(problem);

            List<int[]> nextSteps = IntStream.of(0, 1, 2, 3)
                    .mapToObj(i -> new int[]{x + dx[i], y + dy[i]})
                    .filter(n -> n[0] >= 0 && n[0] < map.length && n[1] >= 0 && n[1] < map[0].length
                            && map[n[0]][n[1]] < map[x][y])
                    .collect(Collectors.toList());

            boolean isSubProblemReady = nextSteps.stream()
                    .filter(n -> memo[n[0]][n[1]] == -1)
                    .peek(subProblems::push)
                    .findAny().isEmpty();
            if (!isSubProblemReady) continue;

            memo[x][y] = nextSteps.stream()
                    .filter(n -> memo[n[0]][n[1]] != -1)
                    .mapToInt(n -> memo[n[0]][n[1]])
                    .sum();
        }
        return String.valueOf(memo[0][0]);
    }
    
}
