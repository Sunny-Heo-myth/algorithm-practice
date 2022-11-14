package practice.baekjoon.stepbystep.bruteForceStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(disassembleSum(Integer.parseInt(bf.readLine())));
    }

    static int disassembleSum(int x) {
        int candidate = 0;
        while (true) {
            char[] chars = Integer.toString(candidate).toCharArray();
            int sum = candidate;
            for (int i = 0; i < chars.length; i++) {
                sum += chars[i] - 48;
            }
            if (sum == x) return candidate;
            if (candidate >= x) return 0;
            candidate++;
        }

    }
}
