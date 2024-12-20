package org.alan.algorithm.practice.baekjoon.problem;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ11967 {
    public String solve(String input) {
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int length = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        boolean[][] isBright = new boolean[length][length];
        boolean[][] isSwitchOn = new boolean[length][length];
        isBright[0][0] = true;

        Map<List<Integer>, List<int[]>> roomToSwitchMap = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.groupingBy(
                        row -> Arrays.asList(row[0] - 1, row[1] - 1),
                        Collectors.mapping(row -> new int[]{row[2] - 1, row[3] - 1}, Collectors.toList())));

        boolean didBashTurnedOnNewLight = true;
        Queue<int[]> bash;
        boolean[][] visited;
        while (didBashTurnedOnNewLight) {
            didBashTurnedOnNewLight = false;
            bash = new LinkedList<>();
            visited = new boolean[length][length];

            bash.offer(new int[]{0, 0});
            visited[0][0] = true;
            while (!bash.isEmpty()) {
                int[] poll = bash.poll();
                int x = poll[0], y = poll[1];

                List<Integer> key = List.of(x, y);
                if (roomToSwitchMap.containsKey(key) && !isSwitchOn[x][y]) {
                    isSwitchOn[x][y] = true;
                    roomToSwitchMap.get(key).forEach(room -> isBright[room[0]][room[1]] = true);
                    didBashTurnedOnNewLight = true;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= length || ny >= length || visited[nx][ny] || !isBright[nx][ny]) continue;

                    bash.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        int answer = 0;
        for (boolean[] line : isBright) for (boolean light : line) if (light) answer++;
        return String.valueOf(answer);
    }

    public String solve2(String input) {    // todo:
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int length = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        boolean[][] isBright = new boolean[length][length];
        boolean[][] visited = new boolean[length][length];

        Map<List<Integer>, List<int[]>> roomToSwitchMap = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .collect(Collectors.groupingBy(
                        row -> Arrays.asList(row[0] - 1, row[1] - 1),
                        Collectors.mapping(row -> new int[]{row[2] - 1, row[3] - 1}, Collectors.toList())));

        Queue<int[]> queue = new LinkedList<>();
        List<int[]> brightButNotVisitedRoomList = new ArrayList<>();

        queue.offer(new int[]{0, 0});
        isBright[0][0] = true;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];

            List<Integer> key = List.of(x, y);
            if (roomToSwitchMap.containsKey(key)) {
                roomToSwitchMap.get(key).forEach(button -> isBright[button[0]][button[1]] = true);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= length || ny >= length || visited[nx][ny] || !isBright[nx][ny]) continue;

                queue.offer(new int[]{0, 0});
                visited[0][0] = true;
            }
        }

        int answer = 0;
        for (boolean[] line : isBright) for (boolean light : line) if (light) answer++;
        return String.valueOf(answer);
    }
}
