package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24511Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4\n" +
                        "0 1 1 0\n" +
                        "1 2 3 4\n" +
                        "3\n" +
                        "2 4 7", "4 1 2"),
                Arguments.of("5\n" +
                        "1 1 1 1 1\n" +
                        "1 2 3 4 5\n" +
                        "3\n" +
                        "1 3 5", "1 3 5"),
                Arguments.of("5\n" +
                        "1 1 0 1 1\n" +
                        "1 2 3 4 5\n" +
                        "5\n" +
                        "1 3 5 4 2", "3 1 3 5 4"),
                Arguments.of("5\n" +
                        "0 0 0 0 0\n" +
                        "1 2 3 4 5\n" +
                        "8\n" +
                        "1 3 5 7 4 3 3 3", "5 4 3 2 1 1 3 5"),
                Arguments.of("10\n" +
                        "0 0 0 0 0 1 1 1 1 1\n" +
                        "1 2 3 4 5 6 7 8 9 10\n" +
                        "3\n" +
                        "1 3 5", "5 4 3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24511 instance = new BJ24511();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
