package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ14500Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 5\n" +
                        "1 2 3 4 5\n" +
                        "5 4 3 2 1\n" +
                        "2 3 4 5 6\n" +
                        "6 5 4 3 2\n" +
                        "1 2 1 2 1", "19"),
                Arguments.of("4 5\n" +
                        "1 2 3 4 5\n" +
                        "1 2 3 4 5\n" +
                        "1 2 3 4 5\n" +
                        "1 2 3 4 5", "20"),
                Arguments.of("4 10\n" +
                        "1 2 1 2 1 2 1 2 1 2\n" +
                        "2 1 2 1 2 1 2 1 2 1\n" +
                        "1 2 1 2 1 2 1 2 1 2\n" +
                        "2 1 2 1 2 1 2 1 2 1", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ14500 instance = new BJ14500();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
