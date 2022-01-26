package baekjoon.java.javaWhile;

import java.util.Scanner;

public class BJ1110 {

    public static void main(String[] args) {
        int input = new Scanner(System.in).nextInt();
        System.out.println(cycle(input));
    }

    static int cycle (int input) {
        if (input == 0) return 1;
        int original = input;
        int count = 0;
        int deci0th;
        int deci1st;
        int y;
        String s;

        do {
            count += 1;
            if (input < 10) {
                deci0th = input;
                deci1st = 0;
            } else {
                s = Integer.toString(input);
                deci1st = Character.getNumericValue(s.charAt(0));
                deci0th = Character.getNumericValue(s.charAt(1));
            }
            y = deci0th + deci1st;

            if (y < 10) input = deci0th * 10 + y;
            else input = deci0th * 10 + Character.getNumericValue(Integer.toString(y).charAt(1));
        } while (original != input);

        return count;
    }
}
