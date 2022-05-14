package baekjoon.stepByStep.javaBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15650_2 {
    static int N;
    static int M;
    static boolean[] booleans;
    static int[] ints;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        booleans = new boolean[N];
        ints = new  int[M];
        stringBuilder = new StringBuilder();

        dfs(0);
        System.out.print(stringBuilder);
    }

    public static void dfs(int count) {
        if (M == count) {
            for (int i : ints) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!booleans[i]) {
                for (int j = 0; j < i + 1; j++) {
                    booleans[j] = true;
                }
                ints[count] = i + 1;
                dfs(count + 1);
                for (int j = 0; j < i + 1; j++) {
                    booleans[j] = false;
                }
            }
        }
    }
}
