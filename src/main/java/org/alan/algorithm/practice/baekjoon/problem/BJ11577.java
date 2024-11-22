package org.alan.algorithm.practice.baekjoon.problem;

import java.util.regex.Pattern;

public class BJ11577 {
    public String solve(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int N = Integer.parseInt(firstLine[0]), K = Integer.parseInt(firstLine[1]);
        int[] arr = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        int[] flips = new int[N];
        int count = 0, result = 0;
        for (int i = 0; i < N; i++) {
            if (i >= K) count -= flips[i - K];
            if ((arr[i] + count) % 2 == 0) continue;
            if (i + K > N) return "Insomnia";

            count++;
            result++;
            flips[i] = 1;
        }

        return String.valueOf(result);
    }
}
