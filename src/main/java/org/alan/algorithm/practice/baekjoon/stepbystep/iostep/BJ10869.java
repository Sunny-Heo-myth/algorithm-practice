package org.alan.algorithm.practice.baekjoon.stepbystep.iostep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10869 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);
        System.out.println(first + second);
        System.out.println(first - second);
        System.out.println(first * second);
        System.out.println(first / second);
        System.out.print(first % second);
    }

}
