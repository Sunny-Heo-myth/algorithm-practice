package org.alan.algorithm.practice.baekjoon.stepbystep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class BJ18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];
        // sorted array of origin
        HashMap<Integer, Integer> rankingMap = new HashMap<>();
        // Maps for unique value of array (element, rank)

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            sorted[i] = input;
            origin[i] = input;
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {  // time complexity : n
            if (!rankingMap.containsKey(v)) {  //  time complexity : n
                rankingMap.put(v, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            // key is unique element in origin
            // value is the rank so the each element of origin will be mapped to rank
            sb.append(rankingMap.get(key)).append(' ');
        }

        System.out.println(sb);


    }
}