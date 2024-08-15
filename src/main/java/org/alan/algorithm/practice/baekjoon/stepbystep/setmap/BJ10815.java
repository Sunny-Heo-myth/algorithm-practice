package org.alan.algorithm.practice.baekjoon.stepbystep.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10815 {
    boolean[] existence = new boolean[200000001];
    int[] candidates;

    public BJ10815(String inputString) {
        String[] lines = inputString.split("\n");
        int[] ints = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int index : ints) {
            existence[index + 10000000] = true;
        }
        candidates = Arrays.stream(lines[3].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine() + "\n" + bf.readLine() + "\n" +bf.readLine() + "\n" +bf.readLine();
        System.out.print(new BJ10815(input).answer());
    }

    public String answer() {
        StringBuilder result = new StringBuilder();
        for (int index : candidates) {
            if (existence[index + 10000000]) {
                result.append(1);
            } else {
                result.append(0);
            }
            result.append(" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
