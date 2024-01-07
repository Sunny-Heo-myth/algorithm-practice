package org.alan.algorithm.practice.baekjoon.tagged.geometry;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ3495 {
    private static final char INCREMENT = '/';
    private static final char DECREMENT = '\\';

    public String solve(String input) {
        char[][] m = Pattern.compile("\n").splitAsStream(input).skip(1).map(String::toCharArray).toArray(char[][]::new);
        return String.valueOf(getSpaceCount(m) + Arrays.stream(m)
                .flatMapToInt(chars -> IntStream.range(0, chars.length).map(i -> chars[i]))
                .filter(ch -> ch == INCREMENT || ch == DECREMENT).count() / 2);
    }

    private int getSpaceCount(char[][] m) {
        int spaceCount = 0;
        for (char[] value : m) {
            boolean isStarted = false;
            int from = 0;
            int to;
            for (int j = 0; j < value.length; j++) if (value[j] == INCREMENT || value[j] == DECREMENT)
                if (!isStarted) {
                    isStarted = true;
                    from = j;
                } else {
                    isStarted = false;
                    to = j;
                    spaceCount += to - from - 1;
                }
        }
        return spaceCount;
    }
}
