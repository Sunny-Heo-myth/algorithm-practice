package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class                       BJ10816 {
    private final int[] keyArray;
    private final int[] to;
    private final Map<Integer, Integer> answerMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(bf.readLine()).append("\n");
        }

        BJ10816 instance = new BJ10816(sb.substring(0, sb.length() - 1));
        System.out.print(instance.answer());
    }

    public BJ10816(String input) {
        String[] lines = input.split("\n");
        keyArray = Arrays.stream(lines[3].split(" ")).mapToInt(Integer::parseInt).toArray();
        to = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        answerMap = new HashMap<>();
    }

    public String answer() {
        Arrays.stream(keyArray).forEach(i -> answerMap.put(i, 0));
        Arrays.stream(to).forEach(i -> {
            if (answerMap.get(i) == null) {
                return;
            }

            answerMap.put(i, answerMap.get(i) + 1);
        });

        return toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int key : keyArray) {
            sb.append(answerMap.get(key)).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
