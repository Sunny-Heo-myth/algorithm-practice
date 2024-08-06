package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10996Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", """
                        *"""),
                Arguments.of("2", """
                        *
                         *
                        *
                         *"""),
                Arguments.of("3", """
                        * *
                         *
                        * *
                         *
                        * *
                         *"""),
                Arguments.of("4", """
                        * *
                         * *
                        * *
                         * *
                        * *
                         * *
                        * *
                         * *""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10996().solve(input));
    }
}
