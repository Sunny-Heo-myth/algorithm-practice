package com.baekjoonPractice.stepByStep.stringStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941 {
    // c= 99 61
    // c- 99 45
    // dz= 100 122 61
    // d- 100 45
    // lj 108 106
    // nj 110 106
    // s= 115 61
    // z= 122 61
    public static void main(String[] args) throws IOException {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        char[] chars = (s + "  ").toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length - 2; i++) {
            switch (chars[i]) {
                case 99 : if (chars[i + 1] == 61 || chars[i + 1] == 45) i++; break;
                case 100 :
                    if (chars[i + 1] == 122 && chars[i + 2] == 61) i += 2;
                    else if (chars[i + 1] == 45) i++;
                    break;
                case 108 :
                case 110 :
                    if (chars[i + 1] == 106) i++; break;
                case 115 :
                case 122 :
                    if (chars[i + 1] == 61) i++; break;
            }
            count++;
        }
        System.out.print(count);
    }
}
