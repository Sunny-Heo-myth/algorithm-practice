package com.baekjoonPractice.stepByStep.math2Step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3053 {

    public static void main(String[] args) throws IOException {
        int i = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        System.out.print(Math.PI * Math.pow(i, 2) + "\n" + 2*Math.pow(i, 2));
    }
}
