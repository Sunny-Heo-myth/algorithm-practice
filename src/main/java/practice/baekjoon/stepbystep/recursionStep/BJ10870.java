package practice.baekjoon.stepbystep.recursionStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10870 {

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.print(fibonacci(x));
    }

    static int fibonacci(int x) {
        if (x == 0) return 0;
        else if (x == 1) return 1;
        else return fibonacci(x - 1) + fibonacci(x - 2);
    }
}
