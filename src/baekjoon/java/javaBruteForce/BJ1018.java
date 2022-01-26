package baekjoon.java.javaBruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

}
