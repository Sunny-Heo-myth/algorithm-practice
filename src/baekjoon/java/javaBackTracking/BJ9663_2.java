package baekjoon.java.javaBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9663_2 {
    static boolean[][] booleans;
    static int[] point = new int[2];
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        booleans = new boolean[n][n];

        nQueen(0, booleans);
        System.out.print(answer);
    }

    public static void nQueen(int count, boolean[][] booleans) {

        if (count == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int[] point = new int[]{i, j};
                queenRoute(point);
                if (routeCheck(point)) {
                    nQueen(count + 1, booleans);
                }

            }
        }
    }

    public static void queenRoute(int[] point) {
        for (int i = 0; i < n; i++) {

            boolean b = booleans[point[0]][i];
            if (b) {
               // return false;
            }
            else {
                b = true;
            }

            b = booleans[i][point[1]];
        }
    }

    public static boolean routeCheck(int[] point) {
        return true;
    }
}
