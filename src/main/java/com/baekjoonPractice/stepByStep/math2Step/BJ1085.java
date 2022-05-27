package com.baekjoonPractice.stepByStep.math2Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        ints[2] -= ints[0]; ints[3] -= ints[1];
        int min = Arrays.stream(ints)
            .min()
            .getAsInt();

        System.out.print(min);
    }

}
