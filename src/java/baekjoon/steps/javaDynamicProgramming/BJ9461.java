package baekjoon.steps.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {

    static Long[] longArray = new Long[101];

    public static void main(String[] args) throws IOException {
        longArray[1] = 1L;
        longArray[2] = 1L;
        longArray[3] = 1L;
        longArray[4] = 2L;
        longArray[5] = 2L;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(padovan(Integer.parseInt(bf.readLine()))).append("\n");
        }
        System.out.print(sb);
    }

    static Long padovan(int num) {
        if (num <= 5) {
            return longArray[num];
        }

        if (longArray[num] == null) {
            longArray[num] = padovan(num - 1) + padovan(num - 5);
        }
        return longArray[num];
    }

}
