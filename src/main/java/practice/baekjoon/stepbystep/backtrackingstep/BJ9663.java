package practice.baekjoon.stepbystep.backtrackingstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663 {
    static boolean[][] booleans;
    static int[] point = new int[2];
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        booleans = new boolean[n][n];

        nQueen(0);
        System.out.print(answer);
    }

    public static void nQueen(int count) {

        if (count == n) {
            answer++;
            return;
        }

        boolean erasable = false;
        for (int i = 0; i < n; i++) {
            if (!booleans[point[0]][i]) {
                erasable = true;
                break;
            }
            if (!booleans[i][point[1]]) {
                erasable = true;
                break;
            }
        }

        int right = 5 - Math.abs(point[0] - point[1]);
        if (point[0] >= point[1]) {
            for (int i = 0; i < right; i++) {
                if (!booleans[point[0] - point[1] + i][i]) {
                    erasable = true;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < right; i++) {
                if (!booleans[i][point[0] - point[1] + i]) {
                    erasable = true;
                    break;
                }
            }
        }

        int inverse = (2*n - 1) - (point[0] + point[1]);
        for (int i = 0; i < inverse; i++) {

        }
        if (count != 0) {
            return;
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (!booleans[k][l]) {

                    for (int i = 0; i < n; i++) {
                        if (!booleans[point[0]][i]) {
                            erasable = true;
                            break;
                        }
                        if (!booleans[i][point[1]]) {
                            erasable = true;
                            break;
                        }
                    }
                    point = new int[]{k, l};
                    nQueen(count + 1);
                }
            }
        }
    }
}
