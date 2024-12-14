package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13913Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1 2", """
                        1
                        1 2"""),
                Arguments.of("5 17", """
                        4
                        5 4 8 16 17""")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
//        Assertions.assertEquals(expected, new BJ13913().solve(input));
    }

}
