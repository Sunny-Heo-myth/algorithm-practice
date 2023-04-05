package org.alan.algorithm.practice.baekjoon.stepbystep.arraystep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean[] booleans = new boolean[30];
        int count = 0;
        for (int i = 0; i < 28; i++) {
            booleans[Integer.parseInt(bf.readLine()) - 1] = true;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            if (!booleans[i]) {
                answer.append(i + 1).append("\n");
                count++;
            }
            if (count == 2) {
                break;
            }
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }
}
