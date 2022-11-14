package practice.baekjoon.stepbystep.stringStep;

import java.util.Arrays;
import java.util.Scanner;

public class BJ10809 {

    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        char[] chars = s.toCharArray();
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        for (char c : chars) {
            int now = Character.getNumericValue(c) - 10;
            if (alphabet[now] == -1) alphabet[now] = s.indexOf(Character.toString(c));
        }
        StringBuilder sb = new StringBuilder();
        for (int i : alphabet) sb.append(i).append(" ");
        System.out.print(sb);
    }
}
