package org.alan.algorithm.practice.baekjoon.stepbystep.bruteforcestep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1018 {

    static char[][] board1 = {
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray()
    };
    static char[][] board2 = {
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray(),
        "BWBWBWBW".toCharArray(),
        "WBWBWBWB".toCharArray()
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int axis1st = Integer.parseInt(input[0]);
        int axis2nd = Integer.parseInt(input[1]);

        char[][] inputBoard = new char[axis1st][axis2nd];
        for (int i = 0; i < axis1st; i++) {
            inputBoard[i] = bf.readLine().toCharArray();
        }

        System.out.print(solution(inputBoard));
    }

    static int solution(char[][] inputBoard) {
        int inputAxis1st = inputBoard.length - 7;
        int inputAxis2nd = inputBoard[0].length - 7;
        int count1 = Integer.MAX_VALUE;
        int count2 = Integer.MAX_VALUE;

        for (int i = 0; i < inputAxis1st; i++) {
            for (int j = 0; j < inputAxis2nd; j++) {
                int countCandidate1 = 0;
                int countCandidate2 = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (board1[k][l] != inputBoard[i + k][j + l]) countCandidate1++;
                        if (board2[k][l] != inputBoard[i + k][j + l]) countCandidate2++;
                    }
                }
                if (countCandidate1 < count1) count1 = countCandidate1;
                if (countCandidate2 < count2) count2 = countCandidate2;
            }
        }
        return Math.min(count1, count2);
    }

    private static final char[][] BOARD_TYPE_1 = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };

    private static final char[][] BOARD_TYPE_2 = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };

    // brute force
    public String solve(String input) {
        char[][] chars = Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(String::toCharArray).toArray(char[][]::new);
        long answer = Math.min(getMin(chars, BOARD_TYPE_1), getMin(chars, BOARD_TYPE_2));
        return String.valueOf(answer);
    }

    private long getMin(char[][] chars, char[][] boardType) {
        return IntStream.range(0, chars.length - 7).mapToLong(m -> IntStream.range(0, chars[0].length - 7).mapToLong(n ->
                IntStream.range(0, 8).mapToLong(i -> IntStream.range(0, 8).filter(j -> chars[m + i][n + j] != boardType[i][j])
                        .count()).sum()).min().orElse(0)).min().orElse(0);
    }
}
