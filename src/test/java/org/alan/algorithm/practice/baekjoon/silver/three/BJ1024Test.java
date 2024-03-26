package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1024Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("18 2", "5 6 7"),
                Arguments.of("18 4", "3 4 5 6"),
                Arguments.of("18 5", "-1"),
                Arguments.of("45 10", "0 1 2 3 4 5 6 7 8 9"),
                Arguments.of("1000000000 2", "199999998 199999999 200000000 200000001 200000002")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1024().solve(input));
    }
}
