package org.alan.algorithm.practice.baekjoon.stepbystep.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10807_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        String s = bf.readLine();
        String x = bf.readLine();
        long answer = Arrays.stream(s.split(" "))
                .filter(i -> i.equals(x))
                .count();
        System.out.print(answer);
    }
}
