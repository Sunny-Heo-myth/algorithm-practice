package org.alan.algorithm.practice.baekjoon.stepbystep.geometry;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1004Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2\n" +
                        "-5 1 12 1\n" +
                        "7\n" +
                        "1 1 8\n" +
                        "-3 -1 1\n" +
                        "2 2 2\n" +
                        "5 5 1\n" +
                        "-4 5 1\n" +
                        "12 1 1\n" +
                        "12 1 2\n" +
                        "-5 1 5 1\n" +
                        "1\n" +
                        "0 0 2",
                        "3\n" +
                        "0"),
                Arguments.of("3\n" +
                        "-5 1 5 1\n" +
                        "3\n" +
                        "0 0 2\n" +
                        "-6 1 2\n" +
                        "6 2 2\n" +
                        "2 3 13 2\n" +
                        "8\n" +
                        "-3 -1 1\n" +
                        "2 2 3\n" +
                        "2 3 1\n" +
                        "0 1 7\n" +
                        "-4 5 1\n" +
                        "12 1 1\n" +
                        "12 1 2\n" +
                        "12 1 3\n" +
                        "102 16 19 -108\n" +
                        "12\n" +
                        "-107 175 135\n" +
                        "-38 -115 42\n" +
                        "140 23 70\n" +
                        "148 -2 39\n" +
                        "-198 -49 89\n" +
                        "172 -151 39\n" +
                        "-179 -52 43\n" +
                        "148 42 150\n" +
                        "176 0 10\n" +
                        "153 68 120\n" +
                        "-56 109 16\n" +
                        "-187 -174 8",
                        "2\n" +
                        "5\n" +
                        "3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1004 instance = new BJ1004();
    }
}
