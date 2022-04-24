package baekjoon.steps.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2156 {
    static int[] numArray;
    static Integer[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        numArray = new int[n + 1];
        dpArray = new Integer[n + 1];
        for (int number = 1; number < n + 1; number++) {
            numArray[number] = Integer.parseInt(bf.readLine());
        }

        dpArray[0] = 0;
        dpArray[1] = numArray[1];

        if (n > 1) {
            dpArray[2] = numArray[1] + numArray[2];
        }

        System.out.print(recur(n));
    }

    static int recur(int number) {
        if (dpArray[number] == null) {
            dpArray[number] = Math.max(
                    Math.max(recur(number - 2), recur(number - 3) + numArray[number - 1])
                            + numArray[number],
                    recur(number - 1)
            );
        }
        return dpArray[number];
    }
}
