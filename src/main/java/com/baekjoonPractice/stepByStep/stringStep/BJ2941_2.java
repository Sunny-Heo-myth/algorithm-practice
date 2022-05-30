package com.baekjoonPractice.stepByStep.stringStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2941_2 {

    static String[] croatia = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
    static ArrayList<String> croatia2;

    public static void main(String[] args) throws IOException {
        croatia2 = new ArrayList<>();
        for (String s : croatia) {
            croatia2.add(s);
        }
        System.out.print(croatianCount(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    static public int croatianCount(String input) {
        int index = 0;
        int count = 0;

        while (index < input.length()) {
            count++;

            if (index + 3 <= input.length() && "dz=".equals(input.substring(index, index + 3))) {
                index += 3;
                continue;
            }

            if (index + 2 <= input.length() && croatia2.contains(input.substring(index, index + 2))) {
                index += 2;
                break;
            }
            else {
                index++;
            }
        }
        return count;
    }
}
