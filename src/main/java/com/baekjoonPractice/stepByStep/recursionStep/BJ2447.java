package com.baekjoonPractice.stepByStep.recursionStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2447 {

    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        char[][] y = prettyStar(x);
        StringBuilder sb = new StringBuilder();
        for (char[] chars : y) sb.append(String.valueOf(chars)).append("\n");
        System.out.print(sb);
    }

    static char[][] prettyStar(int x) {
        char[][] picture;
        if (x == 3) {
            picture = new char[][]{{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}};
        }
        else {
            picture = new char[x][x];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (i == 1 && j == 1) {
                        for (int m = x/3; m < 2*x/3; m++) {
                            for (int n = x/3; n < 2*x/3; n++) {
                                picture[m][n] = ' ';
                            }
                        }
                    }
                    else {
                        char[][] temp = prettyStar(x/3);

                        for (int m = 0; m < temp.length; m++) {
                            System.arraycopy(temp[m], 0, picture[i*x/3 + m], j*x/3, temp[0].length);
                        }
                    }
                }
            }
        }

        return picture;
    }
}
