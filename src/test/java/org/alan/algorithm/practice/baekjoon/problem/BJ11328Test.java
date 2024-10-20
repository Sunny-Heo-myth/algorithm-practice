package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11328Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("a a", "Possible"),
                Arguments.of("ab ba", "Possible"),
                Arguments.of("ring gnir", "Possible"),
                Arguments.of("newt twan", "Impossible")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11328().solve(input));
    }
}
