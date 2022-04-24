package baekjoon.steps.javaBackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15649 {
    static int n;
    static int m;
    static boolean[] check;
    static int[] ints;
    static StringBuilder sb;

    static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n];
        ints = new int[m];
        sb = new StringBuilder();

        nAndM_1(0);
        System.out.print(sb);
        System.out.print(temp);
    }

    public static void nAndM_1(int count) {

        if (count == m) {
            for (int i : ints) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            temp++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                ints[count] = i + 1;
                nAndM_1(count + 1);
                check[i] = false;
            }
        }

    }
}
