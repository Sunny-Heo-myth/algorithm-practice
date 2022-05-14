package baekjoon.stepByStep.javaDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2747 {
    static int[] numbers = new int[91];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        numbers[0] = 0;
        numbers[1] = 1;
        System.out.print(fibo(Integer.parseInt(bf.readLine())));
    }

    static int fibo(int x) {

        if (x >= 2 && numbers[x] == 0) {
             numbers[x] = fibo(x - 1) + fibo(x - 2);
        }

        return numbers[x];
    }
}
