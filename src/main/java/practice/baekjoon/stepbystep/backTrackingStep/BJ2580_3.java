package practice.baekjoon.stepbystep.backTrackingStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        if (axis2nd == 9) { // when goes to next row,
            sudoku(axis1st + 1, 0);
            return;
        }

        if (axis1st == 9) { // when the recursion ends,
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            
            System.out.println(sb);
            System.exit(0); // forcefully terminate process when the first outcome comes out.
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

    public static boolean possibility(int axis1st, int axis2nd, int number) {

        for (int i = 0; i < 9; i++) {
            if (arr[axis1st][i] == number) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][axis2nd] == number) {
                return false;
            }
        }

        int setAxis1st = (axis1st / 3) * 3;
        int setAxis2nd = (axis2nd / 3) * 3;

        for (int i = setAxis1st; i < setAxis1st + 3; i++) {
            for (int j = setAxis2nd; j < setAxis2nd + 3; j++) {
                if (arr[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

}