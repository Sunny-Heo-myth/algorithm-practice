package org.alan.algorithm.practice.programmers;

import java.util.Arrays;

public class PG389481 {
    public String solution(long n, String[] bans) {
        long N = Arrays.stream(bans)
                .mapToLong(ban -> {
                    char[] chars = ban.toCharArray();
                    long tban = 0;
                    for (int i = 0; i < chars.length; i++) {
                        tban += ((chars[i] - ('a' - 1)) * (long) Math.pow(26, chars.length - 1 - i));
                    }
                    return tban;
                })
                .sorted()
                .reduce(n, (acc, tban) -> acc += (acc >= tban ? 1 : 0));

        String answer = "";
        while (N-- > 0) {
            long quotient = N / 26, remainder = N % 26;
            answer = ((char) ('a' + remainder)) + answer;
            N = quotient;
        }
        return answer;
    }
}
