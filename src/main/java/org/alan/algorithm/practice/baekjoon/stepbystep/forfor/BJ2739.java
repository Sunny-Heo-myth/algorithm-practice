package org.alan.algorithm.practice.baekjoon.stepbystep.forfor;

import java.util.Scanner;

public class BJ2739 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 1; i < 10; i++) System.out.println(input + " * " + i + " = " + input*i);
    }

}
