package org.alan.algorithm.practice.baekjoon.stepbystep.stringstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2941_3 {

    static String[] croatia = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {

        System.out.print(croatianCount(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    static public int croatianCount(String input) {
        int length = input.length();
        int i = 0;
        int count = 0;

        while (i < length) {
            count++;

            if (i + 3 <= length && "dz=".equals(input.substring(i, i + 3))) {
                i += 3;
            }
            else if (i + 2 <= length) {
                for (String s : croatia) {
                    if (s.equals(input.substring(i, i + 2))) {
                        i++;
                        break;
                    }
                }
                i++;
            }
            else {
                i++;
            }
        }

        int j = 0;
        // j is something
        for (j = 3; j <= 10;) {
            // something
            j++;
        }
        return count;
    }

}
