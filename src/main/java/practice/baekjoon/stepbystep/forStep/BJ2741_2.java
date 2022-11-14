package practice.baekjoon.stepbystep.forStep;

import java.util.Scanner;

public class BJ2741_2 {

    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = x; i >= 1; i--) sb.append(Integer.toString(i)).append("\n");
        System.out.println(sb);
    }
}
