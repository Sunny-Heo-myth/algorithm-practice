package org.alan.algorithm.practice.baekjoon.stepbystep.callstep;

import java.util.Scanner;

public class BJ1065_2 {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int count = 0;
        for (int i = 1; i < (n + 1); i++) if(han(i)) count++;
        System.out.println(count);
    }

    static boolean han(int x) {
        if (x < 100) return true;
        if (x == 1000) return false;
        int deci2nd = x / 100;
        int deci1st = (x - deci2nd * 100) / 10;
        int deci0th = x - deci2nd * 100 - deci1st * 10;
        return (deci2nd - deci1st) == (deci1st - deci0th);
    }
}
