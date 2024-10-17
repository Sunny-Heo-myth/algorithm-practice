package org.alan.algorithm.practice.baekjoon.problem;

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
}
