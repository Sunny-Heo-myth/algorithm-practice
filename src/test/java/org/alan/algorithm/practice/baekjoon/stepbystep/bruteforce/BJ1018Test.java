package org.alan.algorithm.practice.baekjoon.stepbystep.bruteforce;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ1018Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("8 8\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBBBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW", "1"),
                Arguments.of("10 13\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "BBBBBBBBWBWBW\n" +
                        "BBBBBBBBBWBWB\n" +
                        "WWWWWWWWWWBWB\n" +
                        "WWWWWWWWWWBWB", "12"),
                Arguments.of("8 8\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB", "0"),
                Arguments.of("9 23\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                        "BBBBBBBBBBBBBBBBBBBBBBW", "31"),
                Arguments.of("10 10\n" +
                        "BBBBBBBBBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBWBWBWBWB\n" +
                        "BWBWBWBWBB\n" +
                        "BBBBBBBBBB", "0"),
                Arguments.of("8 8\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBBBWBW\n" +
                        "WBWBWBWB\n" +
                        "BWBWBWBW\n" +
                        "WBWBWWWB\n" +
                        "BWBWBWBW", "2"),
                Arguments.of("11 12\n" +
                        "BWWBWWBWWBWW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBWWWBWW\n" +
                        "WBWWBWBBWWBW\n" +
                        "BWWBWBBWWBWW\n" +
                        "WBWWBWBBWWBW", "15")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1018().solve(input));
    }

}