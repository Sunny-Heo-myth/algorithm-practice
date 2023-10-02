package org.alan.algorithm.practice.baekjoon.stepbystep.twodimensionarraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2566 {
    int[][] matrix = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            stringBuilder.append(bf.readLine()).append("\n");
        }
        BJ2566 instance = new BJ2566(stringBuilder.toString());
        System.out.print(instance.answer());
    }

    public BJ2566(String input) {
        String[] strings = input.split("\n");
        for (int i = 0; i < 9; i++) {
            String[] row = strings[i].split(" ");
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
    }

    public String answer() {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int x = matrix[i][j];
                if (matrix[i][j] > max) {
                    max = x;
                    row = i;
                    column =j;
                }
            }
        }
        row++;
        column++;
        return sb.append(max).append("\n").append(row).append(" ").append(column).toString();
    }
}
