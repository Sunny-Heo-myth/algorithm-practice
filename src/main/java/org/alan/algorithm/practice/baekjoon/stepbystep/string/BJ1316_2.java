package org.alan.algorithm.practice.baekjoon.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1316_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bf.readLine());
        String[] strings = new String[cases];
        for (int i = 0; i < cases; i++) {
            strings[i] = bf.readLine();
        }

        int answer = 0;
        for (String s : strings) {
            char[] chars = s.toCharArray();
            ArrayList<Character> characters = new ArrayList<>();

            char flagChar = chars[0];
            boolean flag = true;
            for (int i = 1; i < chars.length; i++) {

                if (characters.contains(chars[i])) {
                    flag = false;
                    break;
                }

                if (flagChar != chars[i]) {
                    characters.add(flagChar);
                    flagChar = chars[i];
                }

            }

            if (flag) {
                answer++;
            }
        }
        System.out.print(answer);
    }

}
