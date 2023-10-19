package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10986Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 3\n" +
                        "1 2 3 1 2", "7"),
                Arguments.of("2 3\n" +
                        "1 2", "1"),
                Arguments.of("1 5\n" +
                        "1", "0"),
                Arguments.of("3 5\n" +
                        "1 6 11", "0"),
                Arguments.of("3 5\n" +
                        "5 10 11", "3"),
                Arguments.of("10 1000000\n" +
                        "1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000 1000000", "55")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10986 instance = new BJ10986();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
