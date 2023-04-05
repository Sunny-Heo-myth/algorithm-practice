package org.alan.algorithm.practice.baekjoon.stepbystep.iostep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        double first = Double.parseDouble(input.split(" ")[0]);
        double second = Double.parseDouble(input.split(" ")[1]);
        System.out.println(first / second);
    }
}
