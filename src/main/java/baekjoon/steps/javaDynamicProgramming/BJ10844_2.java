package baekjoon.steps.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10844_2 {
    static Long[][] digitArray;
    final static int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        digitArray = new Long[input + 1][10];
        for (int i = 0; i < 10; i++) {
            digitArray[1][i] = 1L;
        }

        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += recur(input, i);
        }
        System.out.print(result % MOD);
    }

    static long recur(int digit, int value) {
        if (digit == 1) {
            return digitArray[1][value];
        }

        if (digitArray[digit][value] == null) {

            if (value == 0) {
                digitArray[digit][value] = recur(digit - 1, 1);
            }
            else if (value == 9) {
                digitArray[digit][value] = recur(digit - 1, 8);
            }
            else {
                digitArray[digit][value] = recur(digit - 1, value - 1) + recur(digit - 1, value + 1);
            }
        }
        return digitArray[digit][value] % MOD;
    }
}
