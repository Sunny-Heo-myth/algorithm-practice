package com.baekjoonPractice.stepByStep.sortStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution(ints));
    }

    public static String solution(int[] ints) {

        int n = ints.length;
        int[] original = new int[n];
        System.arraycopy(ints, 0, original, 0, n);

        Arrays.sort(ints);

        int rank = 0;
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int element : ints) {
            if (!rankMap.containsKey(element)) {
                rankMap.put(element, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rankMap.get(original[i])).append(" ");
        }
        return sb.toString();
    }
}