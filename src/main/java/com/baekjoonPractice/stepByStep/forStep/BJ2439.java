package com.baekjoonPractice.stepByStep.forStep;

import java.util.Scanner;

public class BJ2439 {

    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= x; i++) s.append(" ".repeat(x - i)).append("*".repeat(i)).append("\n");
        System.out.print(s);
    }
}
