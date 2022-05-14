package baekjoon.stepByStep.javaBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580 {
    static int[][] sudoku = new int[9][9];
    static int zeroCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    zeroCount++;
                }
                sudoku[i][j] = num;
            }
        }

        fill(0);


    }

    public static void fill(int count) {

        if (zeroCount == count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            return;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    int possible = able(i, j);
                    if (possible != 0) {
                        sudoku[i][j] = possible;
                    }
                    fill(count + 1);
                }
            }
        }
    }

    public static int able(int axis1st, int axis2nd) {
        boolean[] check = new boolean[10];

        for (int i = 0; i < 9; i++) {
            check[sudoku[axis1st][i]] = true;
        }

        for (int i = 0; i < 9; i++) {
            check[sudoku[i][axis2nd]] = true;
        }

        int set1st = (axis1st/3)*3;
        int set2nd = (axis2nd/3)*3;

        if (axis1st < 3) {
            if (axis2nd < 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            } else if (axis2nd < 6) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 3; j < 6; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    for (int j = 6; j < 9; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            }
        } else if (axis1st < 6) {
            if (axis2nd < 3) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 0; j < 3; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            } else if (axis2nd < 6) {
                for (int i = 3; i < 6; i++) {
                    for (int j = 3; j < 6; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            } else {
                for (int i = 3; i < 6; i++) {
                    for (int j = 6; j < 9; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            }
        } else {
            if (axis2nd < 3) {
                for (int i = 6; i < 9; i++) {
                    for (int j = 0; j < 3; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            } else if (axis2nd < 6) {
                for (int i = 6; i < 9; i++) {
                    for (int j = 3; j < 6; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            } else {
                for (int i = 6; i < 9; i++) {
                    for (int j = 6; j < 9; j++) {
                        check[sudoku[i][j]] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (!check[i]) {
                return i;
            }
        }
        return 0;
    }

}
