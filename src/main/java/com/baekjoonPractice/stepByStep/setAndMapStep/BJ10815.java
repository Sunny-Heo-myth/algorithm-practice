package com.baekjoonPractice.stepByStep.setAndMapStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BJ10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCards = Integer.parseInt(bf.readLine());
        int[] cards = new int[numberOfCards];
        String[] strings = bf.readLine().split(" ");
        Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
