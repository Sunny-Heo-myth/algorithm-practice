package com.baekjoonPractice.stepByStep.stringStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int[] ints = new int[2];
        for (int i = 0; i < input.length; i++) {
            char[] chars = input[i].toCharArray();
            char tmp = chars[2];
            chars[2] = chars[0];
            chars[0] = tmp;
            ints[i] = Integer.parseInt(String.valueOf(chars));
        }
        System.out.print(Math.max(ints[0], ints[1]));
    }
}
