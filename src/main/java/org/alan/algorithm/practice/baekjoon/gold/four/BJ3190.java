package org.alan.algorithm.practice.baekjoon.gold.four;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ3190 {

    public String solve(String input) {
        int[] dx = {0, 1, 0, -1}; int[] dy = {1, 0, -1, 0}; String[] ss = input.split("\n");
        int N = Integer.parseInt(ss[0]); int K = Integer.parseInt(ss[1]); Boolean[][] map = new Boolean[N][N];
        input.lines().skip(2).limit(K).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).forEach(ints -> map[ints[0] - 1][ints[1] - 1] = Boolean.TRUE);
        Queue<String> turns = input.lines().skip(3 + K).collect(Collectors.toCollection(LinkedList::new));
        Queue<int[]> worm = new LinkedList<>();
        int t = 0;

        worm.offer(new int[]{0, 0});
        map[0][0] = Boolean.FALSE;
        int direction = 0;
        int nx = worm.peek()[0] + dx[direction]; int ny = worm.peek()[1] + dy[direction];

        while (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != Boolean.FALSE) {
            t++;

            if (map[nx][ny] == null) {
                int[] poll = worm.poll();
                map[poll[0]][poll[1]] = null;
            }

            worm.offer(new int[]{nx, ny});
            map[nx][ny] = Boolean.FALSE;

            if (!turns.isEmpty()) {
                String[] peek = turns.peek().split(" ");
                if (t == Integer.parseInt(peek[0])) {
                    turns.poll();
                    if (Objects.equals(peek[1], "L")) direction = (direction + 3) % 4;
                    else direction = (direction + 1) % 4;
                }
            }
            nx += dx[direction]; ny += dy[direction];
        }

        return String.valueOf(t + 1);
    }

}
