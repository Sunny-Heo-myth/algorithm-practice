package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11723 {
    private final boolean[] bitMap = new boolean[21]; // Index refers element.
    private final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BJ11723 instance = new BJ11723();

        int n = Integer.parseInt(bf.readLine());
        for (int xx = 0; xx < n; xx++) {
            String s = bf.readLine();
            if (s.equals("all")) Arrays.fill(instance.bitMap, true);
            else if (s.equals("empty")) Arrays.fill(instance.bitMap, false);
            else instance.operate(s);
        }

        System.out.print(instance.sb);
        bf.close();
    }

    private void operate(String s) {
        String[] ss = s.split(" ");
        int i = Integer.parseInt(ss[1]);
        switch (ss[0]) {
            case "add": bitMap[i] = true; break;
            case "remove": bitMap[i] = false; break;
            case "check": sb.append(bitMap[i] ? 1 : 0).append("\n"); break;
            case "toggle": bitMap[i] = !bitMap[i];
        }
    }
}
