package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16236Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3\n" +
                        "0 0 0\n" +
                        "0 0 0\n" +
                        "0 9 0", "0"),
                Arguments.of("3\n" +
                        "0 0 1\n" +
                        "0 0 0\n" +
                        "0 9 0", "3"),
                Arguments.of("4\n" +
                        "4 3 2 1\n" +
                        "0 0 0 0\n" +
                        "0 0 9 0\n" +
                        "1 2 3 4", "14"),
                Arguments.of("6\n" +
                        "5 4 3 2 3 4\n" +
                        "4 3 2 3 4 5\n" +
                        "3 2 9 5 6 6\n" +
                        "2 1 2 3 4 5\n" +
                        "3 2 1 6 5 4\n" +
                        "6 6 6 6 6 6", "60"),
                Arguments.of("6\n" +
                        "6 0 6 0 6 1\n" +
                        "0 0 0 0 0 2\n" +
                        "2 3 4 5 6 6\n" +
                        "0 0 0 0 0 2\n" +
                        "0 2 0 0 0 0\n" +
                        "3 9 3 0 0 1", "48"),
                Arguments.of("6\n" +
                        "1 1 1 1 1 1\n" +
                        "2 2 6 2 2 3\n" +
                        "2 2 5 2 2 3\n" +
                        "2 2 2 4 6 3\n" +
                        "0 0 0 0 0 6\n" +
                        "0 0 0 0 0 9", "39")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16236().solve(input));
    }
}
