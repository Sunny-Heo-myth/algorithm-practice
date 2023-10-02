package org.alan.algorithm.practice.baekjoon.stepbystep.mathstep.one;

import java.util.Scanner;
public class BJ2839_3 {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int threeKiloBag = 0;
        int fiveKiloBag = 0;

        while (n > 0) {
            if (n%5 != 0) {
                threeKiloBag++;
                n -= 3;
            } else {
                fiveKiloBag = n/5;
                System.out.print(threeKiloBag + fiveKiloBag);
                System.exit(0);
            }
        }

        if (n == 0) {
            System.out.print(threeKiloBag);
        } else {
            System.out.print(-1);
        }

    }
}
