package org.alan.algorithm.practice.baekjoon.stepbystep.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class BJ4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int numberOfTokens = Integer.parseInt(st.nextToken());
            int sum = 0;
            int[] numbers = new int[numberOfTokens];
            for (int j = 0; j < numberOfTokens; j++) {
                int now = Integer.parseInt(st.nextToken());
                numbers[j] = now;
                sum += now;
            }
            float average = (float) sum/numberOfTokens;
            int studentCount = 0;
            for (int j : numbers) if (j > average) studentCount++;

            double y = Math.round((float) studentCount/numberOfTokens * 100000) / 1000.0;
            DecimalFormat format = new DecimalFormat("###0.000");
            sb.append(format.format(y)).append("%").append("\n");
        }
        System.out.print(sb);
    }
}
