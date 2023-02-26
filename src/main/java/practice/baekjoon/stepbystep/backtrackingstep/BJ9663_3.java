package practice.baekjoon.stepbystep.backtrackingstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663_3  {

    static int[] sudoku;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sudoku = new int[N];

        nQueen(0);
        System.out.println(count);

    }

    public static void nQueen(int depth) {

        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            sudoku[depth] = i;

            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    public static boolean Possibility(int col) {

        for (int i = 0; i < col; i++) {

            if (sudoku[col] == sudoku[i]) {
                return false;
            }

            else if (Math.abs(col - i) == Math.abs(sudoku[col] - sudoku[i])) {
                return false;
            }
        }

        return true;
    }
}