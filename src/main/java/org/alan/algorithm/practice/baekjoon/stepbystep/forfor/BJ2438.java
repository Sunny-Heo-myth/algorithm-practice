package org.alan.algorithm.practice.baekjoon.stepbystep.forfor;

import java.util.Scanner;

public class BJ2438 {

    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= x; i++) s.append("*".repeat(i)).append("\n");
        System.out.println(s);
    }
}
