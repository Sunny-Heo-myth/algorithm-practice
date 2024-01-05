package org.alan.algorithm.practice.baekjoon.clazz.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(doom(Integer.parseInt(bf.readLine())));
    }

    static int doom(int order) {
        int doom = 666;
        int count = 0;
        while (true) {
            char[] chars = Integer.toString(doom).toCharArray();
            for (int i = 0; i < chars.length - 2; i++) {
                if (chars[i] == 54 && chars[i + 1] == 54 && chars[i + 2] == 54) {
                    count++;
                    break;
                }
            }
            if (count == order) return doom;
            doom++;
        }
    }

    public String solve(String input) {
        int count = 0;
        long x = 666;
        while (count < Integer.parseInt(input)) if (String.valueOf(x++).contains("666")) count++;
        return String.valueOf(x - 1);
    }
}
