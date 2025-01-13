package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ13300 {
    public String solve(String input) {
        int roomSize = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
        int[][] students = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        int[][] rooms = new int[7][2];

        int count = 0;
        for (int[] student : students) {
            rooms[student[1]][student[0]]++;
            if (rooms[student[1]][student[0]] > roomSize) {
                rooms[student[1]][student[0]] -= roomSize;
                count++;
            }
        }
        return String.valueOf(Arrays.stream(rooms).flatMapToInt(Arrays::stream).filter(i -> i != 0).count() + count);
    }

    public String solve2(String input) {
        int K = Integer.parseInt(input.split("\n")[0].split(" ")[1]);

        int[][] rooms = new int[2][7];
        input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .forEach(sg -> rooms[sg[0]][sg[1]]++);

        return String.valueOf(Arrays.stream(rooms).flatMapToInt(Arrays::stream)
                .map(n -> n / K + (n % K == 0 ? 0 : 1))
                .sum());
    }

}
