package org.alan.algorithm.practice.baekjoon.stepbystep.twodarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2563 {
    boolean[][] whiteBoard = new boolean[100][100];
    int[][] papers;
    int numberOfPapers;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(bf.readLine());
        sb.append(x).append("\n");
        for (int i = 0; i < x; i++) {
            sb.append(bf.readLine()).append("\n");
        }
        BJ2563 instance = new BJ2563(sb.toString());
        instance.attach();
        System.out.print(instance.count());
    }

    public BJ2563(String s) {
        String[] strings = s.split("\n");
        numberOfPapers = Integer.parseInt(strings[0]);
        papers = new int[numberOfPapers][2];
        for (int i = 0; i < numberOfPapers; i++) {
            String[] coordinate = strings[i + 1].split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);
            papers[i][0] = x;
            papers[i][1] = y;
        }
    }

    public void attach() {
        for (int i = 0; i < numberOfPapers; i++) {
            int[] paper = papers[i];
            int x = paper[0];
            int y = paper[1];
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    whiteBoard[j][k] = true;
                }
            }
        }
    }

    public int count() {
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (whiteBoard[i][j]) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
