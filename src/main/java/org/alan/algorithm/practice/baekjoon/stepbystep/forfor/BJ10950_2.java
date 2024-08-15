package org.alan.algorithm.practice.baekjoon.stepbystep.forfor;

import java.util.Scanner;

public class BJ10950_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int sum = sc.nextInt() + sc.nextInt();
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
