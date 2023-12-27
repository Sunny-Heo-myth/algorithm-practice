package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15686Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 3\n" +
                        "0 0 1 0 0\n" +
                        "0 0 2 0 1\n" +
                        "0 1 2 0 0\n" +
                        "0 0 1 0 0\n" +
                        "0 0 0 0 2", "5"),
                Arguments.of("5 2\n" +
                        "0 2 0 1 0\n" +
                        "1 0 1 0 0\n" +
                        "0 0 0 0 0\n" +
                        "2 0 0 1 1\n" +
                        "2 2 0 1 2", "10"),
                Arguments.of("5 1\n" +
                        "1 2 0 0 0\n" +
                        "1 2 0 0 0\n" +
                        "1 2 0 0 0\n" +
                        "1 2 0 0 0\n" +
                        "1 2 0 0 0", "11"),
                Arguments.of("5 1\n" +
                        "1 2 0 2 1\n" +
                        "1 2 0 2 1\n" +
                        "1 2 0 2 1\n" +
                        "1 2 0 2 1\n" +
                        "1 2 0 2 1", "32")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15686().solve(input));
    }
}
