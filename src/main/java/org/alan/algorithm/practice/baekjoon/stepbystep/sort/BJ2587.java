package org.alan.algorithm.practice.baekjoon.stepbystep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2587 {
    private final int[] inputArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(bf.readLine());
        }
        BJ2587 instance = new BJ2587(array);
        System.out.println(instance.mean());
        System.out.print(instance.median());
    }

    public BJ2587(int[] input) {
        this.inputArray = input;
    }

    public int mean() {
        int sum = 0;
        for (int i : inputArray) {
            sum += i;
        }
        return sum / inputArray.length;
    }

    public int median() {
        return Arrays.stream(inputArray).sorted().toArray()[2];
    }
}
