package baekjoon.steps.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2565 {

    static Integer[] dpArray;
    static int[][] wires;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        dpArray = new Integer[n];
        wires = new int[n][2];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(recur(i), max);
        }

        System.out.println(n - max);
    }

    static int recur(int n) {
        if (dpArray[n] == null) {
            dpArray[n] = 1;

            for (int i = n + 1; i < dpArray.length; i++) {
                if (wires[n][1] < wires[i][1]) {
                    dpArray[n] = Math.max(dpArray[n], recur(i) + 1);
                }
            }
        }
        return dpArray[n];
    }
}
