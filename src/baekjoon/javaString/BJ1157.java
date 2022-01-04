package baekjoon.javaString;

import java.util.Scanner;

public class BJ1157 {

    public static void main(String[] args) {
        char[] charArray = new Scanner(System.in).next().toUpperCase().toCharArray();
        int[] alphabetCount = new int[26];
        for (char ch : charArray) alphabetCount[((int) ch) - 65]++;
        int maxCount = Integer.MIN_VALUE;
        int maxCountAscii = 0;
        boolean doubleCount = false;
        for (int i = 0; i < 26; i++) {
            int nowCount = alphabetCount[i];
            if (nowCount > maxCount) {
                doubleCount = false;
                maxCount = nowCount;
                maxCountAscii = i;
            } else doubleCount = nowCount == maxCount;
        }
        if (doubleCount) System.out.print("?");
        else System.out.print((char) (maxCountAscii + 65));
    }
}
