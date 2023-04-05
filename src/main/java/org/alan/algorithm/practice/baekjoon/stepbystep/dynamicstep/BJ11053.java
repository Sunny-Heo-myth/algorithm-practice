package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11053 {
    static int[] intArray;
    static Integer[] dpArray;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        intArray = new int[n];
        dpArray = new Integer[n];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            ascending(i);
        }

        int max = dpArray[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dpArray[i]);
        }
        System.out.print(max);
    }

    static int ascending(int order) {

        if (dpArray[order] == null) {
            dpArray[order] = 1;
            for (int i = order - 1; i >= 0; i--) {
                if (intArray[i] < intArray[order]) {
                    dpArray[order] = Math.max(dpArray[order], ascending(i) + 1);
                }
            }
        }
        return dpArray[order];
    }
}
