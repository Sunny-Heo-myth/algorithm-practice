package baekjoon.java.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1904 {
    static long[] factorialArr = new long[1000001];

    public static void main(String[] args) throws IOException {
        factorialArr[1] = 1;
        factorialArr[2] = 2;
        int num = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(caseOfTiles(num));

    }

    static long caseOfTiles(int num) {
        if (num <= 2) {
            return factorialArr[num];
        }

        if (factorialArr[num] == 0) {
            factorialArr[num] = (caseOfTiles(num - 1) + caseOfTiles(num - 2))%15746;
        }

        return factorialArr[num];
    }


}
