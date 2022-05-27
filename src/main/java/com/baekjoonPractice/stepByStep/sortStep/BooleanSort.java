package com.baekjoonPractice.stepByStep.sortStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BooleanSort {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        boolean[] million = new boolean[2000001];
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            million[Integer.parseInt(bf.readLine()) + 1000000] = true;
        }

        List<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < 2000001; i++) {
            if (million[i]) sortedList.add(i - 1000000);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : sortedList) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);

    }

}
