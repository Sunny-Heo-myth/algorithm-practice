package com.baekjoonPractice.stepByStep.stringStep;

import java.io.IOException;

public class BJ1157_2 {

    public static void main(String[] args) throws IOException {
        int ch = System.in.read();
        int[] alphabet = new int[26];
        while (ch > 64) {
            if (ch < 91) alphabet[ch - 65]++;
            else alphabet[ch - 97]++;
            ch = System.in.read();
        }
        int max = -1;
        int ascii = -2; // ?
        for (int i = 0; i < 26; i++) {
            int now = alphabet[i];
            if (now > max) {
                max = now;
                ascii = i;
            } else if (now == max) ascii = -2;
        }
        System.out.print((char) (ascii + 65));
    }
}
