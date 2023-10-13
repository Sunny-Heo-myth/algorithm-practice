package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BJ10830Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 5\n" +
                        "1 2\n" +
                        "3 4",
                        "69 558\n" +
                        "337 406"),
                Arguments.of("3 3\n" +
                        "1 2 3\n" +
                        "4 5 6\n" +
                        "7 8 9",
                        "468 576 684\n" +
                        "62 305 548\n" +
                        "656 34 412"),
                Arguments.of("5 10\n" +
                        "1 0 0 0 1\n" +
                        "1 0 0 0 1\n" +
                        "1 0 0 0 1\n" +
                        "1 0 0 0 1\n" +
                        "1 0 0 0 1",
                        "512 0 0 0 512\n" +
                        "512 0 0 0 512\n" +
                        "512 0 0 0 512\n" +
                        "512 0 0 0 512\n" +
                        "512 0 0 0 512")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10830 instance = new BJ10830();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}