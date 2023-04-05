package org.alan.algorithm.practice.baekjoon.stepbystep.sortstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int[] ints = new int[n];
        int[] countingArray = new int[8001];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(bf.readLine());
            ints[i] = data;
            countingArray[data + 4000]++;
            sum += data;
        }
        sb.append(Math.round((((float) sum)/n))).append("\n");

        int medianIndex = n/2;
        int median = 0;
        int countSum = 0;

        for (int i = 0; i < 8001; i++) {
            countSum += countingArray[i];
            if (countSum >= medianIndex + 1) {
                median = i - 4000;
                break;
            }
        }
        sb.append(median).append("\n");

        List<Integer> frequencyList = new ArrayList<>();
        int frequency = Integer.MIN_VALUE;
        for (int i = 0; i < 8001; i++) {
            if (countingArray[i] > frequency) frequency = countingArray[i];
        }
        for (int i = 0; i < 8001; i++) {
            if (countingArray[i] == frequency) {
                frequencyList.add(i - 4000);
            }
        }
        if (frequencyList.size() != 1) {
            sb.append(frequencyList.get(1)).append("\n");
        }
        else {
            sb.append(frequencyList.get(0)).append("\n");
        }


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : ints) {
            if (max < i) max = i;
            if (min > i) min = i;
        }
        int range = max - min;
        sb.append(range).append("\n");

        System.out.print(sb);
    }
}
