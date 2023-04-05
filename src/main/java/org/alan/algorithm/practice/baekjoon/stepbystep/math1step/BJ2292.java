package org.alan.algorithm.practice.baekjoon.stepbystep.math1step;

import java.util.Scanner;

public class BJ2292 {

    public static void main(String[] args) {
        double x = new Scanner(System.in).nextDouble();
        System.out.print((int) Math.ceil(Math.pow((x-1)/3 + 0.25, 0.5) + 0.5));
    }
}
