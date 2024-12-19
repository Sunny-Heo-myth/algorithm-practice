package org.alan.algorithm.practice.baekjoon.problem;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BJ16920 {
    public String solve(String input) {
        char WALL = '#', VACANT = '.';
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        int[] steps = Pattern.compile(" ").splitAsStream("0 " + input.split("\n")[1])
                .mapToInt(Integer::parseInt).toArray();
        char[][] map = input.lines().skip(2).map(String::toCharArray).toArray(char[][]::new);
        int xx = map.length, yy = map[0].length;

        int[] answer = new int[steps.length];
        List<Queue<int[]>> queues = Stream.generate(() -> new LinkedList<int[]>()).limit(steps.length).collect(Collectors.toList());
        for (int i = 0; i < xx; i++) for (int j = 0; j < yy; j++) if (map[i][j] != WALL && map[i][j] != VACANT) {
            int person = map[i][j] - '0';
            queues.get(person).offer(new int[]{i, j});
            answer[person]++;
        }

        // Spread one by one iterating queue with predetermined size multiple times
        while (!queues.stream().allMatch(Collection::isEmpty)) {
            for (int person = 1; person <= steps.length - 1; person++) if (!queues.get(person).isEmpty()) {
                int stepRemain = steps[person];

                Queue<int[]> queue = queues.get(person);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    while (size-- > 0) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        for (int i = 0; i < 4; i++) {
                            int nx = x + dx[i], ny = y + dy[i];
                            if (nx < 0 || ny < 0 || nx >= xx || ny >= yy || map[nx][ny] != VACANT) continue;

                            map[nx][ny] = (char) (person + '0');
                            queue.offer(new int[]{nx, ny});
                            answer[person]++;
                        }
                    }
                    if (--stepRemain <= 0) break;
                }
            }
        }
        return Arrays.stream(answer).skip(1).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
