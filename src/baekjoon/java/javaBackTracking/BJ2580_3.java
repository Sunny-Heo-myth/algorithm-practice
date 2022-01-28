package baekjoon.java.javaBackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BJ2580_3 {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int axis1st, int axis2nd) {
        
        if (axis2nd == 9) {
            sudoku(axis1st + 1, 0);
            return;
        }

        if (axis1st == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[axis1st][axis2nd] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(axis1st, axis2nd, i)) {
                    arr[axis1st][axis2nd] = i;
                    sudoku(axis1st, axis2nd + 1);
                }
            }
            arr[axis1st][axis2nd] = 0;
            return;
        }

        sudoku(axis1st, axis2nd + 1);

    }

    public static boolean possibility(int axis1st, int axis2nd, int value) {

        for (int i = 0; i < 9; i++) {
            if (arr[axis1st][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][axis2nd] == value) {
                return false;
            }
        }

        int set_axis1st = (axis1st / 3) * 3; // value가 속한 3x3의 행의 첫
        int set_axis2nd = (axis2nd / 3) * 3;

        for (int i = set_axis1st; i < set_axis1st + 3; i++) {
            for (int j = set_axis2nd; j < set_axis2nd + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

}