package com.baekjoonPractice.stepByStep.callStep;

import java.util.Scanner;

public class BJ1065 {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int count = 0;
        for (int i = 1; i < (n + 1); i++) if(han(i)) count++;
        System.out.println(count);
    }

    static boolean han(int x) {
        if (x < 100) return true;
        String string = Integer.toString(x);
        int length = string.length();
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) intArray[i] = Character.getNumericValue(string.charAt(i));
        for (int i = 0; i < (length - 2); i++) {
            if (intArray[i + 2] - intArray[i + 1] != intArray[i + 1] - intArray[i]) return false;
        }
        return true;
    }
}
