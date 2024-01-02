package org.alan.algorithm.practice.baekjoon.tagged.string;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ17413 {
    public String solve(String input) {
        StringBuilder answer = new StringBuilder();
        int i = -1;
        int beginIndex = 0;
        int endIndex;
        while (++i < input.length()) {
            if (input.charAt(i) == '<') {
                endIndex = i;
                answer.append(reverse(input.substring(beginIndex, endIndex)));
                beginIndex = i;
            }
            if (input.charAt(i) == '>') {
                endIndex = i + 1;
                answer.append(input, beginIndex, endIndex);
                beginIndex = i + 1;
            }
        }
        return answer.append(reverse(input.substring(beginIndex))).toString();
    }

    private String reverse(String input) {
        return Pattern.compile(" ").splitAsStream(input)
                .map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" "));
    }
}
