package org.alan.algorithm.practice.baekjoon.stepbystep.iostep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3003 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(new BJ3003().solve(bf.readLine()));
    }

    public String solve(String input) {
        StringBuilder result = new StringBuilder();
        int[] shouldBe = {1,1,2,2,2,8};
        String[] splits = input.split(" ");
        for (int i = 0; i < 6; i++) {
            result.append((shouldBe[i] -= Integer.parseInt(splits[i]))).append(" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
