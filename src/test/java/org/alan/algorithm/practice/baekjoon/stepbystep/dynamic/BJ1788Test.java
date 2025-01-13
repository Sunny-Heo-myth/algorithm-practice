package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1788Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("-2", """
                        -1
                        1"""),
                Arguments.of("0", """
                        0
                        0"""),
                Arguments.of("1", """
                        1
                        1"""),
                Arguments.of("10", """
                        1
                        55"""),
                Arguments.of("-7", """
                        1
                        13""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1788().solve(input));
    }
}
