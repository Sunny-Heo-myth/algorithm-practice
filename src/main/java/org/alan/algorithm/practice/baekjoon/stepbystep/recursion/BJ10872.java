package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10872 {

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(recursion(x));
    }

    static int recursion(int x) {
        if (x == 0 || x == 1) return 1;
        else return x * recursion(x - 1);
    }

}
