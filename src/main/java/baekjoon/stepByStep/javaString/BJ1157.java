package baekjoon.stepByStep.javaString;

import java.util.Scanner;

public class BJ1157 {

    public static void main(String[] args) {
        String string = new Scanner(System.in).next().toUpperCase();
        int[] alphabetCount = new int[26];
        for (int i = 0; i < string.length(); i++) alphabetCount[string.charAt(i) - 65]++;
        int maxCount = Integer.MIN_VALUE;
        int maxCountAscii = 0;
        boolean doubleCount = false;
        for (int i = 0; i < 26; i++) {
            int nowCount = alphabetCount[i];
            if (nowCount > maxCount) {
                doubleCount = false;
                maxCount = nowCount;
                maxCountAscii = i;
            } else if (nowCount == maxCount) doubleCount = true;
        }
        if (doubleCount) System.out.print("?");
        else System.out.print((char) (maxCountAscii + 65));
    }
}
