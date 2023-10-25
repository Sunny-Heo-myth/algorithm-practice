package org.alan.algorithm.practice.baekjoon.topic.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1004 {
    private final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BJ1004 instance = new BJ1004();
        int n = Integer.parseInt(bf.readLine());
        while (n-- > 0) {
            instance.sb.append(instance.solve(bf)).append("\n");
        }

        System.out.print(instance.sb.deleteCharAt(instance.sb.length() - 1));
    }
    
    public String solve(BufferedReader bf) throws IOException {
        int[] ints = getInts(bf);
        int[] start = {ints[0], ints[1]}; int[] end = {ints[2], ints[3]};
        boolean[] check = new boolean[Integer.parseInt(bf.readLine())];

        int i = check.length;
        while (i-- > 0) {
            int[] ii = getInts(bf);
            double poweredDiameter = Math.pow(ii[2], 2);
            if (Math.pow(ii[0] - start[0], 2) + Math.pow(ii[1] - start[1], 2) < poweredDiameter) check[i] = !check[i];
            if (Math.pow(ii[0] - end[0], 2) + Math.pow(ii[1] - end[1], 2) < poweredDiameter) check[i] = !check[i];
        }

        int count = 0;
        for (boolean b : check) if (b) count++;
        return String.valueOf(count);
    }

    private int[] getInts(BufferedReader bf) throws IOException {
        return Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
