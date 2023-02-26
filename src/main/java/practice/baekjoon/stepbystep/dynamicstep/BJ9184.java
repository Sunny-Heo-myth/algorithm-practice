package practice.baekjoon.stepbystep.dynamicstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9184 {
    static int a;
    static int b;
    static int c;
    static Integer[][][] funFuncArr = new Integer[21][21][21];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        funFuncArr[i][j][k] = 1;
                    }
                }
            }
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(bf.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                System.out.println(sb);
                return;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                    .append(funFunc(a, b, c)).append("\n");

        }
    }

    static int funFunc(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            if (funFuncArr[20][20][20] == null) {
                funFuncArr[20][20][20] = funFunc(20, 20, 20);
            }
            return funFuncArr[20][20][20];
        }

        if (a < b && b < c) {
            if (funFuncArr[a][b][c - 1] == null) {
                funFuncArr[a][b][c - 1] = funFunc(a, b, c - 1);
            }
            if (funFuncArr[a][b - 1][c - 1] == null) {
                funFuncArr[a][b - 1][c - 1] = funFunc(a, b - 1, c - 1);
            }
            if (funFuncArr[a][b - 1][c] == null) {
                funFuncArr[a][b - 1][c] = funFunc(a, b - 1, c);
            }
            return funFuncArr[a][b][c - 1] + funFuncArr[a][ b - 1][ c - 1] - funFuncArr[a][b - 1][c];
        }

        if (funFuncArr[a - 1][b][c] == null) {
            funFuncArr[a - 1][b][c] = funFunc(a - 1, b, c);
        }
        if (funFuncArr[a - 1][b - 1][c] == null) {
            funFuncArr[a - 1][b - 1][c] = funFunc(a - 1, b - 1, c);
        }
        if (funFuncArr[a - 1][b][c - 1] == null) {
            funFuncArr[a - 1][b][c - 1] = funFunc(a - 1, b, c - 1);
        }
        if (funFuncArr[a - 1][b - 1][c - 1] == null) {
            funFuncArr[a - 1][b - 1][c - 1] = funFunc(a - 1, b - 1, c - 1);
        }
        return funFuncArr[a - 1][b][c] + funFuncArr[a - 1][b - 1][c] + funFuncArr[a - 1][b][c - 1] - funFuncArr[a - 1][b - 1][c - 1];
    }
}
