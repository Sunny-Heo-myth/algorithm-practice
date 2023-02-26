package practice.baekjoon.stepbystep.math1step;

import java.util.Scanner;

public class BJ2292_2 {
    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();

        int step = 1;
        while (input > 1) {
            input -= 6 * step;
            step++;
        }
        System.out.print(step);
    }
}
