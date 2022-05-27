package com.baekjoonPractice.stepByStep.math2Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4948 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int aInt = Integer.parseInt(bf.readLine());
            if (aInt == 0) break;

            boolean[] booleans = new boolean[2 * aInt];
            booleans[0] = true;

            int i = 2;
            int count = 0;
            while (i <= aInt) {
                int j = 2;
                while (i * j <= 2 * aInt) {
                    booleans[i * j - 1] = true;
                    j++;
                }
                i++;
            }
            for (int k = aInt; k < 2 * aInt; k++)
                if (!booleans[k])
                    count++;
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
