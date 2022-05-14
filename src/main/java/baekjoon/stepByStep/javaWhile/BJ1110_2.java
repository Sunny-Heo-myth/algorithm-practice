package baekjoon.stepByStep.javaWhile;

import java.util.Scanner;

public class BJ1110_2 {

    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        int original = x;
        int count = 0;
        int deci1st;
        int deci0th;
        int y;

        do {
            count++;
            deci1st = x / 10;
            deci0th = x % 10;
            y = deci1st + deci0th;
            x = deci0th * 10 + y % 10;
        } while (original != x);
        System.out.println(count);
    }
}
