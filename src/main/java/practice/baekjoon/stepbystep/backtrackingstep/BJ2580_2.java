package practice.baekjoon.stepbystep.backtrackingstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580_2  {
        static int[][] sudoku = new int[9][9];


        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            fill(0,0);


        }

        public static void fill(int axis1st, int axis2nd) {

            if (axis2nd == 9) {
                fill(axis1st + 1, 0);
                return;
            }

            if (axis1st == 9) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(sudoku[i][j]).append(" ");
                    }
                    sb.append("\n");
                }

                System.out.print(sb);
                System.exit(0);
            }

            if (sudoku[axis1st][axis2nd] == 0) {
                for (int i = 1; i <= 9; i++) {
                    if (able(axis1st, axis2nd, i)) {
                        sudoku[axis1st][axis2nd] = i;
                        fill(axis1st, axis2nd + 1);
                    }
                }
                sudoku[axis1st][axis2nd] = 0;
                return;
            }

            fill(axis1st, axis2nd + 1);
        }

        public static boolean able(int axis1st, int axis2nd, int number) {
            for (int i = 0; i < 9; i++) {
                if (sudoku[axis1st][i] == number) {
                    return false;
                }
                if (sudoku[i][axis2nd] == number) {
                    return false;
                }
            }

            int newAxis1st = (axis1st/3)*3;
            int newAxis2nd = (axis2nd/3)*3;
            for (int i = newAxis1st; i < newAxis1st + 3; i++) {
                for (int j = newAxis2nd; j < newAxis2nd + 3; j++) {
                    if (sudoku[i][j] == number) {
                        return false;
                    }
                }
            }
            return true;
        }


}
