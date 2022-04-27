package baekjoon.steps.javaString;

import java.util.Scanner;

public class BJ11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] charArray = sc.next().toCharArray();
        int sum = 0;
        for (char c : charArray) sum += Character.getNumericValue(c);
        System.out.print(sum);
    }
}
