package org.alan.algorithm.practice.baekjoon.stepbystep.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ24060Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("16 12\n" +
                        "8 4 13 10 5 6 1 7 15 16 3 2 9 11 12 14", "7")
                , Arguments.of("8 24\n" +
                        "8 4 13 10 5 6 1 7", "13")
                , Arguments.of("8 25\n" +
                        "8 4 13 10 5 6 1 7", "-1")
                , Arguments.of("5 7\n" +
                        "4 5 1 3 2", "3")
                , Arguments.of("5 13\n" +
                        "4 5 1 3 2", "-1")
                , Arguments.of("7 10\n" +
                        "3 5 1 2 7 6 4", "2")
                , Arguments.of("1 1\n" +
                        "1", "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ24060 instance = new BJ24060();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
