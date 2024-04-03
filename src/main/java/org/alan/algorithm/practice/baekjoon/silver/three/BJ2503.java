package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.regex.Pattern;

public class BJ2503 {
    public String solve(String input) {
        boolean[] possible = new boolean[1000];
        for (int i = 123; i < 1000; i++) {
            String s = String.valueOf(i);
            char a = s.charAt(0);
            char b = s.charAt(1);
            char c = s.charAt(2);
            if (a == '0' || b == '0' || c == '0' || a == b || b == c || a == c) continue;
            possible[i] = true;
        }

        Pattern.compile("\n").splitAsStream(input).skip(1).forEach(s -> {
            String[] ss = s.split(" ");
            String guess = ss[0];
            int strike = Integer.parseInt(ss[1]);
            int ball = Integer.parseInt(ss[2]);

            for (int candidate = 123; candidate < 1000; candidate++) {
                if (!possible[candidate]) continue;
                int strikeCount = 0;
                int ballCount = 0;

                for (int i = 0; i < 3; i++) {
                    char guessChar = String.valueOf(guess).charAt(i);
                    for (int j = 0; j < 3; j++) {
                        char candiChar = String.valueOf(candidate).charAt(j);
                        if (guessChar == candiChar && i == j) strikeCount++;
                        else if (guessChar == candiChar && i != j) ballCount++;
                    }
                }

                possible[candidate] = strikeCount == strike && ballCount == ball;
            }
        });




        int count = 0;
        for (int i = 123; i < 1000; i++) if (possible[i]) count++;
        return String.valueOf(count);
    }
}
